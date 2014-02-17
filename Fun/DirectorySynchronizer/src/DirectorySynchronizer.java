
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author Joey Bloom
 * 3/11/13
 */
public class DirectorySynchronizer
{
    private static String todayString = new Date().toString();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle("First Directory to Sync");
        int result = fc.showDialog(null, "Sync");
        if(result == JFileChooser.CANCEL_OPTION)
        {
            System.exit(0);
            return;
        }
        else if(result == JFileChooser.ERROR_OPTION)
        {
            JOptionPane.showMessageDialog(null, "An Error Occured", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return;
        }
        Path baseD1 = fc.getSelectedFile().toPath();

        fc.setDialogTitle("Second Directory to Sync");
        result = fc.showDialog(null, "Sync");
        if(result == JFileChooser.CANCEL_OPTION)
        {
            System.exit(0);
            return;
        }
        else if(result == JFileChooser.ERROR_OPTION)
        {
            JOptionPane.showMessageDialog(null, "An Error Occured", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return;
        }
        Path baseD2 = fc.getSelectedFile().toPath();

        FileVisitor visitor1 = new MyVisitor(baseD2/*this is the corresponding path, eh?*/);
        Files.walkFileTree(baseD1, visitor1);
        FileVisitor visitor2 = new MyVisitor2(baseD1);
        Files.walkFileTree(baseD2,visitor2);

        String log = ((MyVisitor)visitor1).getLog();
        if(!log.isEmpty())
        {
            int choice =
                JOptionPane.showConfirmDialog(
                    null,
                    log +
                        "\nThis is a log of all the files you skipped and logged when prompted to overwrite. " +
                        "Save the log?",
                    "Log",
                    JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION)
            {
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setDialogTitle("Save log");
                fc.showSaveDialog(null);
                try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fc.getSelectedFile()))))
                {
                    out.println(log);
                    out.println(todayString);
                }
            }
        }
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(baseD1.resolve("lastSync.txt").toFile()))))
        {
            out.println("Last Sync: " + todayString);
            out.println("Synced with: " + baseD2);
        }
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(baseD2.resolve("lastSync.txt").toFile()))))
        {
            out.println("Last Sync: " + todayString);
            out.println("Synced with: " + baseD1);
        }

        JOptionPane.showMessageDialog(null,"All done! Goodbye!", "Sync Complete", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Provides the file tree walking functionality
     */
    private static class MyVisitor extends SimpleFileVisitor<Path>
    {
        private Path corresponding;
        private ArrayList<Path> log;
        private boolean first;

        /**
         * Constructs a MyVisitor with corresponding Path c
         * @param c corresponding Path
         */
        public MyVisitor(Path c)
        {
            corresponding = c;
            log = new ArrayList<>();
            first = true;
        }

        /**
         * Returns a (potentially large) String of the Paths that
         * were skipped and logged.
         * @return log of files to inspect manually
         */
        public String getLog()
        {
            String returnMe = "";
            for(Path p : log)
            {
                returnMe += p + "\n";
            }
            return returnMe;
        }

        /**
         * If this directory is absent from the
         * corresponding directory
         *      Copy directory
         * If this directory is present in the
         * corresponding directory
         *      Continue (visit subtree)
         * @param dir directory about to possibly be searched
         * @param attrs
         * @return CONTINUE
         * @throws IOException
         */
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
        {
            if(!first)
            {
                corresponding = corresponding.resolve(dir.getFileName());
            }
            first = false;
            File corr = corresponding.toFile();
            if(corr.isDirectory())
            {
                return FileVisitResult.CONTINUE;
            }
            else
            {
//                JOptionPane.showMessageDialog(null, "Found " + dir + " directory to copy. Copying.");
                Files.copy(dir,corresponding,
                    StandardCopyOption.COPY_ATTRIBUTES,
                    LinkOption.NOFOLLOW_LINKS );
                return FileVisitResult.CONTINUE;
            }
        }

        /**
         * If this file is absent from
         * the corresponding directory
         *      Copies the file and its attributes there
         * If this file is present in the
         * corresponding directory
         *      Prompts for user input as to how to continue
         * @param file Path of file visiting
         * @param attrs BasicFileAttributes of file visiting
         * @return CONTINUE always
         * @throws IOException
         */
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
        {
            Path corrPath = corresponding.resolve(file.getFileName());
            File corrFile = corrPath.toFile();
            if(corrFile.isFile())
            {
                promptToOverwrite(file, corrPath, attrs);
            }
            else
            {
//                JOptionPane.showMessageDialog(null, "Found " + file + " file to copy. Copying.");
                Files.copy(file,corrPath,
                    StandardCopyOption.COPY_ATTRIBUTES);
            }
            return FileVisitResult.CONTINUE;
        }

        /**
         * Prompts the user what he wants to do when an overwrite situation is encountered
         * @param file first file path
         * @param corrPath second file path
         * @param attrs first file attributes
         * @throws IOException
         */
        protected void promptToOverwrite(Path file,Path corrPath,BasicFileAttributes attrs) throws IOException
        {
            FileTime thisTime = attrs.lastModifiedTime();
            FileTime corrTime = Files.getLastModifiedTime(corrPath, LinkOption.NOFOLLOW_LINKS);
            //if the times differ by less than 2 seconds or exactly on the hour, don't copy.
            long diff = thisTime.toMillis() - corrTime.toMillis();
            if( (diff < 2000 && diff > -2000))
            {
                return;
            }
            long HOUR_IN_MILLISECONDS = 1000 * 60 * 60;
            //if within half a second of exactly an hour off
            if(Math.abs(diff) < HOUR_IN_MILLISECONDS + 500 && Math.abs(diff) > HOUR_IN_MILLISECONDS-500)
            {
                if(diff > 0)
                {
                    corrPath.toFile().setLastModified(corrTime.toMillis()+HOUR_IN_MILLISECONDS);
                }
                else
                {
                    file.toFile().setLastModified(thisTime.toMillis()+HOUR_IN_MILLISECONDS);
                }
                return;
            }
            String message = "2 Files, 1 name.\n\n";
                message += file + "\n";
                message += "\tLast Modified: " + thisTime + "\n";
                message += corrPath + "\n";
                message += "\tLast Modified: " + corrTime + "\n";

                Object[] options = {"Skip and Log", "Skip","Keep first","Keep second", "Skip and move last modified time ahead 1 hour"};

                int result = JOptionPane.showOptionDialog(
                    null,
                    message,
                    "What to do?",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    null);

                switch(result)
                {
                    case 0:
                        log.add(file);
                        break;
                    case 2:
                        Files.copy(file,corrPath,
                            StandardCopyOption.COPY_ATTRIBUTES,
                            StandardCopyOption.REPLACE_EXISTING);
                        break;
                    case 3:
                        Files.copy(corrPath,file,
                            StandardCopyOption.COPY_ATTRIBUTES,
                            StandardCopyOption.REPLACE_EXISTING);
                        break;
                    case 4:

                }
        }

        /**
         * If visiting a file fails for any reason, this
         * method alerts the user and prompts for continuation
         * @param file Path of file that was failed to visit
         * @param exc exception thrown when visiting
         * @return CONTINUE or TERMINATE
         * @throws IOException
         */
        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException
        {
            int result = JOptionPane.showConfirmDialog(
                                        null,
                                        "There was a FileIO exception.\n" + exc + "\nContinue walking?",
                                        "Exception",
                                        JOptionPane.YES_NO_OPTION,
                                        JOptionPane.ERROR_MESSAGE);
            if(result == JOptionPane.YES_OPTION)
            {
                return FileVisitResult.CONTINUE;
            }
            else
            {
                return FileVisitResult.TERMINATE;
            }
        }

        /**
         * Resets corresponding Path
         * @param dir
         * @param exc
         * @return
         * @throws IOException
         */
        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
        {
            corresponding = corresponding.getParent();
            return FileVisitResult.CONTINUE;
        }

    }

    /**
     * Provides functionality for walking the file tree a second time
     */
    private static class MyVisitor2 extends MyVisitor
    {
        /**
         * Constructs a MyVisitor2 with a corresponding Path
         */
        public MyVisitor2(Path c)
        {
            super(c);
        }

        /**
         * This is the only difference between MyVisitor2 and MyVisitor.
         * MyVisitor2 skips prompting the user to overwrite because
         * the user has already been prompted in MyVisitor
         * @param file who cares
         * @param corrPath i don't
         * @param attrs you shouldn't either
         * @throws IOException
         */
        @Override
        protected void promptToOverwrite(Path file, Path corrPath, BasicFileAttributes attrs) throws IOException
        {
            //intentionally does nothing when prompted to overwrite.
        }

    }
}
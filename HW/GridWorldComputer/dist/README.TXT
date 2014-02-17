GridworldComputer
By Joey Bloom
Completed May 31, 2013

Here is your guide to a quick overview of the project:

Locate the GridWorldComputer.jar file at GridWorldComputer\dist.
Double-click the file. Alternatively,
Open the project in NetBeans and run the GridWorldComputer class.

Switch to full screen and/or scroll around to get a view of the whole
computer.

If the little brain (the CPU) is in the middle of the window, then the bottom
right is memory and the top left are the registers.

Click "No Program" on the initial JOptionPane. The Multiply program takes pretty
long to execute, if you've got the time.

Having clicked "No program", you should just see the Central Processing Unit
(CPU) which looks like a brain and then a bunch of red sqaures. Each red square
represents a bit that is turned off. A bit is like a light switch: it has two
states, on and off. Try right clicking one of the red squares
and calling the flip() method. It should turn green. Now it is on. Call flip()
again to turn it off, back to red. Playing with bits this way is neat, but
wouldn't it be easier if the computer could do it for you?

Take a look at the line of red bits that goes from (-4,-8) to (-4,-1) inclusive.
This is a register called the accumulator. Below it is another register called
the program counter. Registers are bits that can be accessed quickly by the CPU.
Take a look again at the top line of bits, the accumulator. See how they are
all off? Now right click the brain, click doInstruction(String), and type
exactly the characters between the quotation marks, not including the quotation
marks: "SET 0aa" . After pressing enter or clicking ok, you should see that some
of the bits in the accumulator are green, turned on, now. If a 1 represents
green/on and 0 represents red/off, then the accumulator should look like the
following: 10101010 .

How did the CPU change the value of the accumulator? In the instant after you
clicked ok, the CPU created an Actor to go next to each of the bits in the
accumulator and set each bit. Try clicking the brain, clicking
doInstruction(String), and typing "SET 000" . The accumulator turns all red
again.

This is just one example of the functionality of my project. If you would like
to learn more, you can restart the program and watch the Multiply program run,
or you can take a look at the documentation for the computer package located
at GridWorldComputer\dist\javadoc\index.html.
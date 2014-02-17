package computer;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;
import static computer.CPU.*;
import javax.swing.JOptionPane;

/**
 * <p>
 * Sets up memory, registers, and CPU and provides the location of the first
 * instruction.</p>
 * @author Joey Bloom
 */
public class GridWorldComputer
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new UnboundedGrid<Actor>());

        //this loads all Actors into gridworld so you can play with them.
        //they are then removed later so they don't destroy the memory Bits
        //and register Bits
        Bus[] bs = new Bus[]{
            new IncrementPCBus(),
            new FetchInstructionBus((short)0),
            new ReadBus((short)0),
            new WriteBus((short)0,(byte)0),
            new SetPCBus((short)0),
            new WriteProgramBus((short)0,new short[0]),
            new GetRegisterBus(RegisterBus.ACCUMULATOR),
            new SetRegisterBus(RegisterBus.ACCUMULATOR, (byte)0),
            new AddToRegisterBus(RegisterBus.ACCUMULATOR, (byte)0),
            new SubtractFromRegisterBus(RegisterBus.ACCUMULATOR, (byte)0),
        };
        for(int i = 0; i < bs.length; i++)
        {
            world.add(new Location(-5,5+i),bs[i]);
        }


        //set up memory
        for(int r = 0; r < MemoryBus.MEMORY_R; r++)
        {
            for(int c = 0; c < 8 * MemoryBus.MEMORY_C; c++)
            {
                world.add(new Location(2*r,(c+1) + c / 8 * 2), new Bit(false));
            }
        }

        //set up registers
        //set up program counter
        for(int i = 0; i < RegisterBus.PROGRAM_COUNTER_SIZE; i++)
        {
            world.add(new Location(-2*RegisterBus.PROGRAM_COUNTER + RegisterBus.START_ROW, -i - 1), new Bit(false));
        }
        //set up accumulator
        for(int i = 0; i < RegisterBus.ACCUMULATOR_SIZE; i++)
        {
            world.add(new Location(-2*RegisterBus.ACCUMULATOR + RegisterBus.START_ROW, -i - 1), new Bit(false));
        }
/******/world.show();
        //removes the Buses created earlier
        for(Bus b : bs)
        {
            b.removeSelfFromGrid();
        }
        CPU cpu = new CPU(world);
        world.add(new Location(-2,0),cpu);
        Object[] options = {"Multiply","No program"};
        int o = JOptionPane.showOptionDialog(null, "Whatcha wanna do?", "Do", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
        switch(o)
        {
            case 0:
                //after this program, the accumulator will hold the product of the first
                //SET_ACCUMULATOR argument and the second. multiplication.
                cpu.doProgram(new short[]{
                    //instruction number = 2(line number - 80)
            (short)(SET_ACCUMULATOR | (0xff & Byte.parseByte(JOptionPane.showInputDialog("First factor:\nEnter a number in the range [-128,127]")))),
                    WRITE_FROM_ACCUMULATOR | 0x000,//address 0 is first number
            (short)(SET_ACCUMULATOR | (0xff & Byte.parseByte(JOptionPane.showInputDialog("Second factor:\nEnter a number in the range [-128,127]\nA number between 0 and 5 will allow the program to run in a semi-reasonable amount of time.\nAny number larger than 5 or less than 0 will take a ridiculous amount of time.")))),
                    WRITE_FROM_ACCUMULATOR | 0x001,//address 1 is second number
                    SET_ACCUMULATOR | 0x00,
                    WRITE_FROM_ACCUMULATOR | 0x002,//address 2 is product
                    SET_ACCUMULATOR | 0x01,
                    WRITE_FROM_ACCUMULATOR | 0x003,//address 3 is the number 1
                    SKIP_NEXT_IF_0 | 0x001, //if second is 0, begin the end
                    JUMP | 0x0028, //jump to beginning of loop
                    READ_TO_ACCUMULATOR | 0x002, //THE END, load product to accumulator
                    HALT,
                    READ_TO_ACCUMULATOR | 0x002, //BEGIN LOOP,load product to accumulator
                    ADD_ACCUMULATOR | 0x000, //add first to accumulator
                    WRITE_FROM_ACCUMULATOR | 0x002, //write product back to memory
                    READ_TO_ACCUMULATOR | 0x001, //load second
                    SUBTRACT_ACCUMULATOR | 0x003, //decrement
                    WRITE_FROM_ACCUMULATOR | 0x001, //write second back
                    JUMP | 0x020, //jump to the skip
                },(short)0x0010);
                break;
            case 1:
        }
        //testing
//        WriteProgramBus wpb = new WriteProgramBus((short)0x0030,
//            new short[]{
//                0b1010101_00010101,
//                0b0010010_00100101,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0b1010101_01010101,
//            });
//        world.add(new Location(-1,0),wpb);
    }
}
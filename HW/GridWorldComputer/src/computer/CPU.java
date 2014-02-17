package computer;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import javax.swing.JOptionPane;

/**
 * <p>
 * The CPU is responsible for sending and receiving Buses according to
 * instructions received from memory.
 * </p>
 *
 * <p>
 * Image: brain
 * </p>
 *
 * @author Joey Bloom
 */
public class CPU extends Actor
{
    //bit masks
    protected static final short OPCODE =      -4096; //equivalent to unsigned 0xF000
    protected static final short ARG =    0x0FFF; //this can also be a numeric value
                                                  //as in the case of SET_ACCUMULATOR

    //opcodes
    /**
     * This opcode reads a value from memory
     * and sets the accumulator to that value.
     * The argument is the memory address of
     * of the value to read from.
     */
    public static final short READ_TO_ACCUMULATOR =     0x0000;
    /**
     * This opcode writes the value of the accumulator
     * to memory. The argument is the address to
     * write to.
     */
    public static final short WRITE_FROM_ACCUMULATOR =  0x1000;
    /**
     * This opcode loads a numeric value into the
     * accumulator. The argument is the numeric
     * value. CPU instructions using this
     * opcode should be of the form 0x20##.
     * The 2 indicates this opcode and the ##
     * are two hexadecimal digits to load
     * into the accumulator. The 0 is because
     * the accumulator is only 8 bits.
     */
    public static final short SET_ACCUMULATOR =         0x2000;
    /**
     * This opcode adds a value to the accumulator.
     * The argument is the address of the value
     * to add.
     */
    public static final short ADD_ACCUMULATOR =         0x3000;
    /**
     * This opcode subtracts a value from the accumulator.
     * The argument is the address of the value to subtract.
     */
    public static final short SUBTRACT_ACCUMULATOR=     0x4000;
    /**
     * This opcode sets the program counter to the
     * value of the argument. The argument should be an even number
     * because the program counter always needs to be even.
     */
    public static final short JUMP =                    0x5000;
    /**
     * If the value at the address specified by the argument is 0,
     * this opcode will increment the program counter an additional
     * time before the usual incrementing that is part of the
     * increment-fetch-execute cycle. This causes the next instruction
     * in the program to be skipped.
     */
    public static final short SKIP_NEXT_IF_0 =          0x6000;
    /**
     * After receiving this instruction,
     * the CPU immediately stops execution. The argument
     * can be anything your heart desires.
     */
    public static final short HALT =                    0x7000;

    private boolean halted = true;
    private ActorWorld world;
    private short writeAddress;

    /**
     * Constructs a CPU with a reference to the ActorWorld it
     * is contained in. The ActorWorld reference is only
     * held so the doInstruction method can add and call step.
     */
    public CPU(ActorWorld world)
    {
        this.world = world;
        setColor(null);
    }

    /**
     * Writes a program to memory with a short[] of instructions and
     * the desired initial value of the Program Counter. Begins
     * execution of the program.
     * @param instructions  instructions for this CPU to execute
     * @param pc            initial value of program counter
     */
    public void doProgram(short[] instructions, short pc)
    {
        doInstruction((short)(JUMP | pc));
        halted = false;
        new WriteProgramBus(pc, instructions).putSelfInGrid(getGrid(), getLocation().getAdjacentLocation(Location.SOUTH));
    }

    /**
     * Translates a line of assembly type code into a short instruction
     * for the CPU to execute, and then calls doInstruction(short) on that
     * instruction.
     * @param instruction
     *      should be of the form "OPC ###"
     *      where OPC is the first three letters of the name
     *      of one of the opcode constants, not case sensitive
     *      and ### are the three hexadecimal digit arguments.
     *      precondition: instruction.length() == 7
     *      failure to satisfy this contract will result unpredictably.
     * @throws IllegalArgumentException
     *      if OPC is not the first three letters of the name
     *      of one of the opcode constants.
     */
    public void doInstruction(String instruction) throws IllegalArgumentException
    {
        String opc = instruction.substring(0,3);
        short arg = Short.parseShort(instruction.substring(4),16);
        if(opc.equalsIgnoreCase("rea"))
            doInstruction((short)(READ_TO_ACCUMULATOR | arg));
        else if(opc.equalsIgnoreCase("wri"))
            doInstruction((short)(WRITE_FROM_ACCUMULATOR | arg));
        else if(opc.equalsIgnoreCase("set"))
            doInstruction((short)(SET_ACCUMULATOR | arg));
        else if(opc.equalsIgnoreCase("add"))
            doInstruction((short)(ADD_ACCUMULATOR | arg));
        else if(opc.equalsIgnoreCase("sub"))
            doInstruction((short)(SUBTRACT_ACCUMULATOR| arg));
        else if(opc.equalsIgnoreCase("jum"))
            doInstruction((short)(JUMP | arg));
        else if(opc.equalsIgnoreCase("ski"))
            doInstruction((short)(SKIP_NEXT_IF_0 | arg));
        else if(opc.equalsIgnoreCase("hal"))
            doInstruction((short)(HALT | arg));
        else
            throw new IllegalArgumentException(opc + " is not a valid opcode name");
    }

    /**
     * Performs the specified instruction as if it was read from memory.
     * The method completes the instruction fully before returning. This
     * method will only execute the instruction if the CPU is halted; that is,
     * if it has run out of instructions from memory. Control Flow instructions
     * (SKIP_NEXT_IF_0, HALT) do nothing except for JUMP, which simply sets
     * the program counter.
     * @param instruction to execute
     */
    public void doInstruction(short instruction)
    {
        if(!halted)
        {
            JOptionPane.showMessageDialog(null,"Sorry, I am currently executing a program");
            return;
        }
        short arg = (short)(instruction & ARG);
        Location loc = getLocation();
        Location north = loc.getAdjacentLocation(Location.NORTH);
        Location south = loc.getAdjacentLocation(Location.SOUTH);
        switch(instruction & OPCODE)
        {
            case READ_TO_ACCUMULATOR:
                ReadBus reader =
                    new ReadBus(arg);
                putAndRun(reader,south,south);
                SetRegisterBus setter =
                    new SetRegisterBus(RegisterBus.ACCUMULATOR, reader.get());
                putAndRun(setter,north,south);
                break;
            case WRITE_FROM_ACCUMULATOR:
                GetRegisterBus getter =
                    new GetRegisterBus(RegisterBus.ACCUMULATOR);
                putAndRun(getter,north,south);
                WriteBus writer =
                    new WriteBus(arg,getter.get());
                putAndRun(writer,south,south);
                break;
            case SET_ACCUMULATOR:
                setter =
                    new SetRegisterBus(RegisterBus.ACCUMULATOR, (byte)arg);
                putAndRun(setter,north,south);
                break;
            case ADD_ACCUMULATOR:
                reader =
                    new ReadBus(arg);
                putAndRun(reader,south,south);
                AddToRegisterBus adder=
                    new AddToRegisterBus(RegisterBus.ACCUMULATOR, reader.get());
                putAndRun(adder,north,south);
                break;
            case SUBTRACT_ACCUMULATOR:
                reader =
                    new ReadBus(arg);
                putAndRun(reader,south,south);
                SubtractFromRegisterBus subtracter =
                    new SubtractFromRegisterBus(RegisterBus.ACCUMULATOR, reader.get());
                putAndRun(subtracter,north,south);
                break;
            case JUMP:
                SetPCBus setterPC =
                    new SetPCBus(arg);
                putAndRun(setterPC,north,south);
                break;
        }
    }
    /**
     * Adds the Bus to the same ActorWorld as this CPU
     * at the specified init Location and steps the ActorWorld
     * until it returns to the specified fin Location. Bus
     * is removed from grid.
     * @param b Bus to putAndRun
     * @param init Location to put
     * @param fin Location to stop acting at.
     */
    private void putAndRun(Bus b, Location init, Location fin)
    {
        world.add(init,b);
        b.act();//this extra act() prevents the Bus from being removed when it
                //turns in place on the first step.
        do
        {
            b.act();
        }while(!b.getLocation().equals(fin));
        b.removeSelfFromGrid();
    }

    /**
     * @author Zak Falouji
     * Does a guaranteed random dice roll
     * ME tinks it might be rigged
     * not sure yet
     * @return a random dice roll number
     */
    private int getRandomNumer()
    {
        boolean f = false;
        while(f)
            return 3;

        return 4;
    }

    /**
     * Steps in the execution of the program. Does nothing
     * if the CPU is halted.
     *
     * Generally, the CPU follows an increment-fetch-execute
     * pattern. Execution may take more than one Bus.
     *
     * So when an IncrementPCBus comes back to CPU, then a
     * FetchInstructionBus goes out to fetch the instruction
     * at the address given by the IncrementPCBus.
     *
     * When a FetchInstructionBus comes back, the instruction
     * given by that FetchInstructionBus is executed. The first
     * Bus in that instruction is sent.
     *
     * When any Bus other than an IncrementPCBus or
     * FetchInstructionBus comes back, the CPU either
     * determines and sends the next Bus to complete
     * the instruction or
     * sends an IncrementPCBus to start the next cycle if
     * the current cycle is over.
     */
    @Override
    public void act()
    {
        if(halted) return;
        Location south =
            getLocation().getAdjacentLocation(Location.SOUTH);
        Actor a = getGrid().get(south);
        Bus b;

        if(a instanceof Bus) b = (Bus)a;
        else return;

        if(b == null) return;
        else if(b instanceof WriteProgramBus)//if it is the first WriteProgramBus returning to CPU
        {
            b.removeSelfFromGrid();
            world.add(
                    getLocation().getAdjacentLocation(Location.NORTH),
                    new IncrementPCBus());
            return;
        }
        else if((b instanceof MemoryBus   && b.getDirection() != Location.WEST) ||
                (b instanceof RegisterBus && b.getDirection() != Location.EAST))
                //if the Bus hasn't completed yet
        {
            return;
        }
        b.removeSelfFromGrid();
        if(b instanceof IncrementPCBus)
        {
            if(b.getOpcode() == SKIP_NEXT_IF_0)
                world.add(
                    getLocation().getAdjacentLocation(Location.NORTH),
                    new IncrementPCBus());
            else
                world.add(
                    south,
                    new FetchInstructionBus(
                        ((IncrementPCBus)b).getNextInstructionAddress()));
        }
        else if(b instanceof FetchInstructionBus)
        {
            short inst = ((FetchInstructionBus)b).getNextInstruction();
//JOptionPane.showMessageDialog(null, "Instruction: " + inst);
            short arg = (short)(inst & ARG);
            switch(inst & OPCODE)
            {
                case READ_TO_ACCUMULATOR:
                    world.add(south,new ReadBus(inst));
                    break;
                case WRITE_FROM_ACCUMULATOR:
                    world.add(
                        getLocation().getAdjacentLocation(Location.NORTH),
                        new GetRegisterBus(
                            (short)(WRITE_FROM_ACCUMULATOR | RegisterBus.ACCUMULATOR)));
                    writeAddress = arg;
                    break;
                case SET_ACCUMULATOR:
                    world.add(
                        getLocation().getAdjacentLocation(Location.NORTH),
                        new SetRegisterBus(
                            (short)(SET_ACCUMULATOR | RegisterBus.ACCUMULATOR),
                            (byte)arg));
                    break;
                case ADD_ACCUMULATOR:
                    world.add(south,new ReadBus(inst));
                    break;
                case SUBTRACT_ACCUMULATOR:
                    world.add(south,new ReadBus(inst));
                    break;
                case JUMP:
                    world.add(
                        getLocation().getAdjacentLocation(Location.NORTH),
                        new SetPCBus(inst));
                    break;
                case SKIP_NEXT_IF_0:
                    world.add(south,new ReadBus(inst));
                    break;
                case HALT:
                    halted = true;
                    JOptionPane.showMessageDialog(null,"Halted! Program complete.");
                    return;
            }
        }
        else if(b instanceof ReadBus)
        {
            short opcode = b.getOpcode();
            byte val = ((ReadBus)b).get();
            switch(opcode)
            {
                case READ_TO_ACCUMULATOR:
                    world.add(
                        getLocation().getAdjacentLocation(Location.NORTH),
                        new SetRegisterBus(
                            (short)(opcode | RegisterBus.ACCUMULATOR),
                            val));
                    break;
                case ADD_ACCUMULATOR:
                    world.add(
                        getLocation().getAdjacentLocation(Location.NORTH),
                        new AddToRegisterBus(
                            (short)(opcode | RegisterBus.ACCUMULATOR),val));
                    break;
                case SUBTRACT_ACCUMULATOR:
                    world.add(
                        getLocation().getAdjacentLocation(Location.NORTH),
                        new SubtractFromRegisterBus(
                            (short)(opcode | RegisterBus.ACCUMULATOR), val));
                    break;
                case SKIP_NEXT_IF_0:
                    if(val == 0)
                    {
                        world.add(
                            getLocation().getAdjacentLocation(Location.NORTH),
                            new IncrementPCBus(SKIP_NEXT_IF_0));
//                        JOptionPane.showMessageDialog(null, "Skipping!!!");
                    }
                    else
                    {
                        world.add(
                            getLocation().getAdjacentLocation(Location.NORTH),
                            new IncrementPCBus());
                    }
                    break;
            }
        }
        else if(b instanceof GetRegisterBus)
        {
            short opcode = b.getOpcode();
            byte val = ((GetRegisterBus)b).get();
            switch(opcode)
            {
                case WRITE_FROM_ACCUMULATOR:
                    world.add(south,
                        new WriteBus((short)(opcode | writeAddress),val));
                    break;
            }
        }
        else
//            if(
//            b instanceof WriteBus |
//            b instanceof SetRegisterBus |
//            b instanceof AddToRegisterBus |
//            b instanceof SetPCBus |
//            b instanceof SubtractFromRegisterBus |
//            b instanceof WriteProgramBus)
        {
            world.add(
                getLocation().getAdjacentLocation(Location.NORTH),
                new IncrementPCBus());
        }
    }
}

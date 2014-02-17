/**
<h4>GridworldComputer</h4>
<h6>By Joey Bloom</h6>
<h6>Completed May 31, 2013</h6>

<p>Below are some of my musings on the functionality of my project. Basic
understanding of Gridworld is assumed. Understanding of hexadecimal and binary
number operations helps.</p>

--------------------------------------------------------------------------------<br/>
FOREWORD<br/>
--------------------------------------------------------------------------------<br/><br/>

<p>
In the course of making this project, many of my friends and classmates have
questioned its value. Truthfully, I too began to question its value at times.
What is the purpose of creating this "GridworldComputer" when its functionality
is limited and its performance is dismal at best? They and I all have fully
functional, high-enough performing computers.
</p>

<p>
I see this project primarily as an educational tool. It can be used to visually
show what a CPU is, what memory is, and how the two interact. It shows how the
CPU reads from and writes to memory and registers among other tasks. It can
also help students understand efficiency of code. When programming in a high
level language like Java, the underlying machine instructions are often
concealed. Tasks that are one line of code in Java may actually be several
instructions for the machine. The Bus Actors help to show this. Each Bus
represents a task executed by the CPU. So when a student observes how programs
written for GridworldComputer run, the student sees how tasks break down on
the machine level and understands how different lines of code in Java may
execute slower or faster, in more steps or fewer.
</p>

--------------------------------------------------------------------------------<br/>
Table of Contents<br/>
--------------------------------------------------------------------------------<br/><br/>

<p>
1. Quickstart<br/>
2. Memory/Addresses<br/>
3. Registers<br/>
4. Buses<br/>
5. CPU Instructions<br/>
6. CPU
<div style="padding-left:50px">
    6a. doInstruction()<br/>
    6b. doProgram()<br/>
</div>
7. Sources<br/>
</p>

--------------------------------------------------------------------------------<br/>
1. Quickstart<br/>
--------------------------------------------------------------------------------<br/><br/>

<p>
Here is your guide to a quick overview of the project:
</p>

<p>
Open the project in NetBeans and run the GridWorldComputer class.
Switch to full screen and/or scroll around to get a view of the whole
computer.
</p>

<p>
If the little brain (the CPU) is in the middle of the window, then the bottom
right is memory and the top left are the registers.
</p>

<p>
Click "No Program" on the initial JOptionPane. The Multiply program takes pretty
long to execute.
</p>

<p>
Having clicked "No program", you should just see the Central Processing Unit
(CPU) which looks like a brain and then a bunch of red sqaures. Each red square
represents a bit that is turned off. A bit is like a light switch: it has two
states, on and off. Try right clicking one of the red squares
and calling the flip() method. It should turn green. Now it is on. Call flip()
again to turn it off, back to red. Playing with bits this way is neat, but
wouldn't it be easier if the computer could do it for you?
</p>

<p>
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
</p>

<p>
How did the CPU change the value of the accumulator? In the instant after you
clicked ok, the CPU created an Actor to go next to each of the bits in the
accumulator and set each bit. Try clicking the brain, clicking
doInstruction(String), and typing "SET 000" . The accumulator turns all red
again.
</p>

<p>
This is just one example of the functionality of my project. If you would like
to learn more, you can restart the program and watch the Multiply program run,
or you can continue reading this documentation.
</p>

--------------------------------------------------------------------------------<br/>
2. Memory/Addresses<br/>
--------------------------------------------------------------------------------<br/><br/>

<p>
Memory is displayed as rows of {@link computer.Bit}s on an UnboundedGrid. I
desired to implement
12-bit memory addresses, so the number of unique memory addresses is
2^12 = 4096. If each memory address indicates a byte of memory then the maximum
memory capacity for this computer is 4096 bytes = 4 kB.
</p>

<p>
Addresses in memory point to a single byte. Addresses are most easily
represented as three hexadecimal digits. 0x precedes a hexadecimal numeral.
Addresses are represented by a short value of the form 0xRRC where RR is 8 bits
indicating the row to visit and C is 4 bits indicating the column. For example,
the address of the byte of memory whose most significant (leftmost) bit is at
Location(4,11) is 0x021 since it is the second row and first column
(all row and column counting begins at 0).
</p>

--------------------------------------------------------------------------------<br/>
3. Registers<br/>
--------------------------------------------------------------------------------<br/><br/>

<p>
Registers are small amounts of memory stored near the CPU to be accessed
quickly. Using an analogy to object-oriented programming, registers can be
thought of as the instance variables of the CPU. In fact, I could have easily
implemented the registers as instance variables of the CPU class. I chose not
to so that the visual of the CPU accessing registers would exist.
</p>

<p>
The program counter is the bottom register. It is 11 bits long. It represents
the 12-bit memory address of the next instruction that the CPU should execute.
However, because instructions are 2 bytes long (see 5. CPU Instructions) they
are stored only at even memory addresses, so the program counter only needs
to be 11 bits.
</p>

<p>
The top register is the accumulator. It is 1 byte or 8 bits long. It is used
as a temporary storage location for performing addition or subtraction or
loading numbers to memory.
</p>

--------------------------------------------------------------------------------<br/>
4. Buses<br/>
--------------------------------------------------------------------------------<br/><br/>

<p>
This section is not essential for using the program. It contains details on its
implementation.
</p>

<p>
{@link computer.Bus}es are Actors. They move around the World modifying and/or
accessing Bits. The Bus is a sort of worker that communicates between
CPU and memory.
</p>

<p>
Buses have two fields. The first is the address field. The 12 least significant
bits are the address that the Bus will visit. This can be a memory address or
a register address. The 4 most significant bits are the opcode. If a Bus is
created by the CPU as part of the execution of an instruction, the CPU will
give an opcode in the construction in the Bus. Otherwise these 4 bits will all
be 0. There are two direct subclasses of Bus.

<p>
The first direct subclass of Bus is {@link computer.MemoryBus}. All subclasses of MemoryBus
visit memory. There are currently four subclasses of MemoryBus.
<br/>{@link computer.ReadBus}
<br/>{@link computer.WriteBus}
<br/>{@link computer.FetchInstructionBus}
<br/>{@link computer.WriteProgramBus}
</p>

<p>
The second direct subclass of Bus is {@link computer.RegisterBus}. All subclasses of
RegisterBus visit a register. There are currently six
subclasses of RegisterBus.
<br/>{@link computer.GetRegisterBus}
<br/>{@link computer.SetRegisterBus}
<br/>{@link computer.AddToRegisterBus}
<br/>{@link computer.SubtractFromRegisterBus}
<br/>{@link computer.IncrementPCBus}
<br/>{@link computer.SetPCBus}
</p>

--------------------------------------------------------------------------------<br/>
5. CPU Instructions<br/>
--------------------------------------------------------------------------------<br/><br/>

<p>
A CPU instruction is a 16-bit quantity that specifies a unique task for the
CPU to perform. The 4 most significant bits are
the opcode indicating which type of operation is to be performed. The next
12 bits are the "argument", either a memory address or
a numeric value as specified by the particular opcode. If it is a
numeric value, only the 8 least significant bits will be used
because my memory only handles bytes.
</p>
<p>
There are 8 opcodes. These are
the 8 main tasks that a CPU can do. Each is associated with a digit.
<br/>{@link computer.CPU#READ_TO_ACCUMULATOR} = 0
<br/>{@link computer.CPU#WRITE_FROM_ACCUMULATOR} = 1
<br/>{@link computer.CPU#SET_ACCUMULATOR} = 2
<br/>{@link computer.CPU#ADD_ACCUMULATOR} = 3
<br/>{@link computer.CPU#SUBTRACT_ACCUMULATOR} = 4
<br/>{@link computer.CPU#SKIP_NEXT_IF_0} = 5
<br/>{@link computer.CPU#JUMP} = 6
<br/>{@link computer.CPU#HALT} = 7
<br/>Details of each are explained in their documentation.
</p>

<p>
When executing a program, Buses appear in different Colors. Each Color
represents the opcode it is executing. Black means it is part of the
increment or fetch step of the increment-fetch-execute cycle.
A poetic explanation of the logic behind the Colors corresponding to each
opcode follows:<br/><br/>

READ_TO_ACCUMULATOR<br/>
blue<br/>
like some peoples' eyes as they Read stuff<br/>
<br/>
WRITE_FROM_ACCUMULATOR<br/>
gray<br/>
like the graphite of a pencil<br/>
that is used for<br/>
Writing<br/>
<br/>
SET_ACCUMULATOR<br/>
magenta<br/>
the Color<br/>
that does not belong to the Set<br/>
of colors i like<br/>
<br/>
ADD_ACCUMULATOR<br/>
green<br/>
positive<br/>
money<br/>
<br/>
SUBTRACT_ACCUMULATOR<br/>
red<br/>
less<br/>
blood<br/>
<br/>
JUMP<br/>
orange<br/>
prison Jumpsuit<br/>
<br/>
SKIP_NEXT_IF_0<br/>
yellow<br/>
like the roadsign at a<br/>
crossroads<br/>
<br/>
HALT<br/>
null<br/>
because a Bus will never have<br/>
the opcode HALT<br/>
<br/>
</p>
--------------------------------------------------------------------------------<br/>
6. CPU<br/>
--------------------------------------------------------------------------------<br/><br/>

<p>
The CPU is able to function in two ways. It can execute a predetermined
"program" of instructions, or it can execute individual instructions.
</p>

<p>
The CPU can be in two states. It can be executing a program (not halted) or
not executing a program (halted) ready to accept individual instructions. Calling
doProgram() starts the execution of a program and unhalts the CPU. When the program
reaches a HALT instruction, the CPU is halted and execution stops. Then
doInstruction() can be called to execute individual instructions.
</p>

<div style="margin-left:50px">
    ----------------------------------------------------------------------------<br/>
    6a. {@link computer.CPU#doInstruction(String)}<br/>
    ----------------------------------------------------------------------------<br/><br/>

    <p>
    This method is used for executing single CPU instructions. This is similar
    to Lisp's REPL.
    </p>

    <p>
    If the CPU is currently executing a program, this method will not do
    anything when called. When the program reaches a HALT instruction and
    halts, then doInstruction() will function.
    </p>

    <p>
    Note that when using doInstruction, the Buses are not visible as they act.
    Rest assured, they are indeed acting.
    </p>

    <p>
    When writing instructions for doInstruction(String), use the first three
    letters of one of the opcode constants in CPU. In same order as explained
    in 5. CPU Instructions, they are,
    <br/>REA
    <br/>WRI
    <br/>SET
    <br/>ADD
    <br/>SUB
    <br/>SKI
    <br/>JUM
    <br/>HAL<br/>
    However, nothing will happen for SKI or HAL, due to the nature of executing
    single instructions rather than a full program.
    </p>
</div>
<div style="margin-left:50px">
    ----------------------------------------------------------------------------<br/>
    6b. {@link computer.CPU#doProgram(short[],short)}<br/>
    ----------------------------------------------------------------------------<br/><br/>

    <p>
    Use this method to run a predetermined routine of CPU instructions. This
    is similar to how Java and other C-derived languages run.
    <p>
    Due
    to the limitations of Gridworld (one cannot pass an array as a parameter
    when calling methods on Actors at runtime in Gridworld), programs must be
    determined at compiletime.
    </p>

    <p>
    A program is a short[] of CPU instructions. By using the bitwise OR
    operator, <code>|</code>, one can write programs that are pretty human
    readable and also machine readable. Hear is the source for the
    multiplication program:<br/>
    <br/>
    <div style="padding-left:100px;text-indent:-50px">
    <code><p>
    cpu.doProgram(new short[]{</p><p>
(short)(SET_ACCUMULATOR | (0xff & Byte.parseByte(JOptionPane.showInputDialog("First factor:\nEnter a number in the range [-128,127]")))),</p><p>
        WRITE_FROM_ACCUMULATOR | 0x000,//address 0 is first number</p><p>
(short)(SET_ACCUMULATOR | (0xff & Byte.parseByte(JOptionPane.showInputDialog("Second factor:\nEnter a number in the range [-128,127]")))),</p><p>
        WRITE_FROM_ACCUMULATOR | 0x001,//address 1 is second number</p><p>
        SET_ACCUMULATOR | 0x00,</p><p>
        WRITE_FROM_ACCUMULATOR | 0x002,//address 2 is product</p><p>
        SET_ACCUMULATOR | 0x01,</p><p>
        WRITE_FROM_ACCUMULATOR | 0x003,//address 3 is the number 1</p><p>
        SKIP_NEXT_IF_0 | 0x001, //if second is 0, begin the end</p><p>
        JUMP | 0x0028, //jump to beginning of loop</p><p>
        READ_TO_ACCUMULATOR | 0x002, //THE END, load product to accumulator</p><p>
        HALT,</p><p>
        READ_TO_ACCUMULATOR | 0x002, //BEGIN LOOP,load product to accumulator</p><p>
        ADD_ACCUMULATOR | 0x000, //add first to accumulator</p><p>
        WRITE_FROM_ACCUMULATOR | 0x002, //write product back to memory</p><p>
        READ_TO_ACCUMULATOR | 0x001, //load second</p><p>
        SUBTRACT_ACCUMULATOR | 0x003, //decrement</p><p>
        WRITE_FROM_ACCUMULATOR | 0x001, //write second back</p><p>
        JUMP | 0x020, //jump to the skip</p><p>
    },(short)0x0010);</p>
    <br/>
    <br/>
    </code>
    </div>
    One sees that by ORing the opcode constant with the numeric argument, one
    gets a CPU instruction. The first two SET_ACCUMULATORs look weird simply
    because of the JOptionPane input.
    </p>

    <p>
    You can write your own program by following the example of the multiplication
    program above. A major difficulty will be determining the correct argument
    for JUMP. The argument is the memory address that the program
    counter should be set to. This can be determined by the following equation:

    <blockquote>JUMP arg = (2 * line number of program) + initial program counter value</blockquote>

    Line number of the program is the index of the instruction in the array.
    Initial program counter value is the second parameter of the
    doProgram(short[],short) method. Initial program counter needs to always
    be divisible by 16 (in other words, the rightmost hexadecimal digit
    should always be 0).

    </p>
</div>
--------------------------------------------------------------------------------<br/>
7. Sources<br/>
--------------------------------------------------------------------------------<br/><br/>

bus image (accessed 5/12/2013):<br/>
    https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcThqrA9NKgdBPJaD4sq6Cai-mbiPtax4mV7Uf9fwLX6snA2EB7q<br/>
brain image (accessed 5/23/2013):<br/>
    http://png-3.findicons.com/files/icons/2035/medical_icons_for/48/brain.png<br/>

 */
package computer;
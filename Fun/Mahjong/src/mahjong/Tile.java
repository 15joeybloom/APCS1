package mahjong;

/**
 * @author 151bloomj
 */
public class Tile
{
    private final byte myTush;//####SS

    private static final byte SUIT =    0b000011;
    private static final byte NUM =     0b111100;

    public static final byte BAM =      0b000000;
    public static final byte CRACK =    0b000001;
    public static final byte DOT =      0b000010;
    public static final byte HONOR =    0b000011;

    public static final byte FLOWER =   0b000011;
    public static final byte JOKER =    0b000111;
    public static final byte N =        0b001011;
    public static final byte E =        0b001111;
    public static final byte W =        0b010011;
    public static final byte S =        0b010111;

    public static final byte GREEN =    0b000000;
    public static final byte RED =      0b000001;
    public static final byte SOAP =     0b000010;

    /**
     * Constructs a Joker. This constructor is not encouraged.
     * A more explicit construction would be new Tile(JOKER);
     */
    public Tile()
    {
        this(JOKER);
    }
    /**
     * Constructs a Tile such that successive calls on toString() will
     * return name, if name is a valid Tile String as specified in the toString()
     * documentation.
     *
     * This constructor will fail if name is not a valid Tile String as specified
     * in toString().
     * @param name
     * @see Tile.toString()
     */
    public Tile(String name)
    {
        switch(name)
        {
            case "J":
            case "j":
                myTush = JOKER;
                return;
            case "F":
            case "f":
                myTush = FLOWER;
                return;
            case "N":
            case "n":
                myTush = N;
                return;
            case "E":
            case "e":
                myTush = E;
                return;
            case "W":
            case "w":
                myTush = W;
                return;
            case "S":
            case "s":
                myTush = S;
                return;
            case "R":
            case "r":
                myTush = RED;
                return;
            case "G":
            case "g":
                myTush = GREEN;
                return;
            case "0":
                myTush = SOAP;
                return;
        }
        if(name.length() != 2)
        {
            throw new IllegalArgumentException(name + " is not a valid Tile String");
        }
        char n = name.charAt(0);
        String s = name.substring(1);
        if(!Character.isDigit(n) || n == '0')
        {
            throw new IllegalArgumentException(name + " is not a valid Tile String");
        }
        byte suit = s.matches("[Bb]") ? BAM : s.matches("[Cc]") ? CRACK : s.matches("[Dd]") ? DOT : -1;
        if(suit == -1)
        {
            throw new IllegalArgumentException(s + " is not a valid suit");
        }
        myTush = (byte)((Byte.parseByte(Character.toString(n)) << 2) | suit );

    }

    /**
     * Constructs a regular (not honor) Tile.
     * @param num   the number of the Tile
     *              precondition: 1 <= num <= 9
     * @param suit  the suit of the Tile
     *              precondition: suit is BAM, CRACK, or DOT
     */
    public Tile(int num, byte suit)
    {
        if(num < 1 || num > 9 || suit < BAM || suit > DOT)
        {
            throw new IllegalArgumentException(num + " " + suit + " is not a valid Tile");
        }
        myTush = (byte)(((byte)num << 2) | suit);
    }
    /**
     * Constructs a Tile of the given byte
     *
     * Precondition: b is a valid Tile. Subsequent method calls
     * assume this.
     * @param b
     */
    public Tile(byte b)
    {
        myTush = b;
    }
    /**
     * Copy constructor
     * @param t Tile to copy
     */
    public Tile(Tile t)
    {
        this(t.getByte());
    }
    /**
     * Returns BAM, CRACK, DOT, or HONOR as appropriate
     * @return the suit of the Tile as an int
     */
    public int getSuit()
    {
        return myTush & SUIT;
    }
    private static final String[] SUIT_STRINGS = {"B", "C", "D", "H"};
    /**
     * Returns "B", "C", "D", or "H" as appropriate
     * @return the suit of the Tile as a String
     */
    public String getSuitString()
    {
        return SUIT_STRINGS[getSuit()];
    }
    /**
     * Returns true if this Tile is an honor or false otherwise
     * @return false if this Tile is a bam, crack, or dot
     */
    public boolean honor()
    {
        return getSuit() == HONOR || ((myTush & NUM) >> 2) == 0;
    }
    /**
     * Returns the number of this Tile
     * @return the number of this Tile or -1 if honor() == true
     */
    public int getNum()
    {
        if(honor()) return -1;
        return (myTush & NUM) >> 2;
    }
    /**
     * Returns the suit corresponding to the dragon's suit
     *
     * Red is crack
     * Green is bam
     * soap is dot
     *
     * @return BAM, CRACK, or DOT if this is a dragon, or -1 if not a dragon
     */
    public int dragon()
    {
        switch(myTush)
        {
            case RED:
                return CRACK;
            case GREEN:
                return BAM;
            case SOAP:
                return DOT;
        }
        return -1;
    }
    /**
     * Returns true if this Tile is a joker
     * @return true if this Tile is a joker
     */
    public boolean joker()
    {
        return myTush == JOKER;
    }
    /**
     * Returns one of the wind constants or -1 if not a wind
     * @return N, E, W, S, or -1 if not a wind
     */
    public int wind()
    {
        switch(myTush)
        {
            case N:
                return N;
            case E:
                return E;
            case W:
                return W;
            case S:
                return S;
        }
        return -1;
    }
    /**
     * Returns the byte representation of this Tile, so
     * that it may be compared to the constants supplied by
     * this class.
     */
    public byte getByte()
    {
        return myTush;
    }
    /**
     * Returns a String representation of this Tile as it might
     * be seen on a Card
     *
     * Honors:
     * Joker = "J"
     * Flower = "F"
     * Red = "R"
     * Green = "G"
     * Soap = "0"
     * North = "N"
     * East = "E"
     * West = "W"
     * South = "S"
     *
     * else, returns a String of the format NS
     * where N is the one digit number of the Tile
     * and S is B, C, or D corresponding to Bam, Crack, and Dot respectively.
     *
     * Note: if this Tile is an honor, the returned String will be
     * of length 1. if this Tile is not an honor, the returned String will
     * be of length 2.
     * @return a String representing the Tile
     */
    @Override
    public String toString()
    {
        switch(myTush)
        {
            case RED:
                return "R";
            case GREEN:
                return "G";
            case SOAP:
                return "0";

            case N:
                return "N";
            case E:
                return "E";
            case W:
                return "W";
            case S:
                return "S";

            case JOKER:
                return "J";
            case FLOWER:
                return "F";
        }
        assert !honor() && getNum() > 0;
        return getNum() + getSuitString();
    }

    /**
     * Returns the name of the Tile as it would be spoken.
     * Examples:
     * Red
     * Green
     * Soap
     *
     * North
     * East
     * West
     * South
     *
     * Joker
     * Flower
     *
     * 1 Bam
     * 2 Crack
     * 3 Dot
     * @return the name
     */
    public String getName()
    {
        int i;
        if((i = dragon()) != -1)
        {
            return DRAGON_NAMES[i];
        }
        else if(honor())
        {
            return HONOR_NAMES[(myTush & NUM) >> 2];
        }
        return getNum() + " " + SUIT_NAMES[getSuit()];
    }
    private static final String[] DRAGON_NAMES = {"Green", "Red", "Soap"};
    private static final String[] HONOR_NAMES = {"Flower", "Joker", "North", "East", "West", "South"};
    private static final String[] SUIT_NAMES = {"Bam", "Crack", "Dot"};
}

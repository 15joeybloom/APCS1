/**
 * @author Joey Boom
 * Assignment #29
 * Tests the Purse class
 */
public class PurseTester
{
    public static void main(String[] args)
    {
        Purse p = new Purse();
        p.addCoin("Quarter");
        p.addCoin("Dime");
        p.addCoin("Nickel");
        p.addCoin("Penny");
        System.out.println("Original: " + p);
        p.reverse();
        System.out.println("Reversed: " + p);
        
        Purse q = new Purse();
        System.out.println("Original: " + q);
        q.reverse();
        System.out.println("Reversed: " + q);
        
        Purse r = new Purse();
        r.addCoin("Penny");
        System.out.println("Original: " + r);
        r.reverse();
        System.out.println("Reversed: " + r);
        r.transfer(q);
        
        Purse s = new Purse();
        Purse t = new Purse();
        t.addCoin("Penny");
        t.addCoin("Half-dollar");
        Purse u = new Purse();
        u.addCoin("Nickel");
        u.addCoin("Dime");
        
        System.out.println("\nBefore transfer: ");
        System.out.println("s: " + s);
        System.out.println("t: " + t);
        System.out.println("u: " + u);
        
        s.transfer(t);
        
        System.out.println("\nAfter transfer t to s: ");
        System.out.println("s: " + s);
        System.out.println("t: " + t);
        System.out.println("u: " + u);
        
        u.transfer(s);
        
        System.out.println("\nAfter transfer s to u: ");
        System.out.println("s: " + s);
        System.out.println("t: " + t);
        System.out.println("u: " + u);
        
        Purse v = new Purse();
        v.addCoin("Quarter");
        v.addCoin("Dime");
        v.addCoin("Nickel");
        Purse w = new Purse();
        w.addCoin("Quarter");
        w.addCoin("Dime");
        w.addCoin("Nickel");
        Purse x = new Purse();
        x.addCoin("Quarter");
        x.addCoin("Nickel");
        x.addCoin("Dime");
        Purse y = new Purse();
        y.addCoin("Quarter");
        
        System.out.println("\nv: " + v);
        System.out.println("w: " + w);
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("Is v the same as w? " + 
            v.sameContents(w) + w.sameContents(v));
        System.out.println("Is v the same as x? " +
            v.sameContents(x) + x.sameContents(v));
        System.out.println("Is v the same as y? " +
            v.sameContents(y) + y.sameContents(v));
    }
}
/*
Output:
Original: Purse[Quarter, Dime, Nickel, Penny]
Reversed: Purse[Penny, Nickel, Dime, Quarter]
Original: Purse[]
Reversed: Purse[]
Original: Purse[Penny]
Reversed: Purse[Penny]

Before transfer: 
s: Purse[]
t: Purse[Penny, Half-dollar]
u: Purse[Nickel, Dime]

After transfer t to s: 
s: Purse[Penny, Half-dollar]
t: Purse[]
u: Purse[Nickel, Dime]

After transfer s to u: 
s: Purse[]
t: Purse[]
u: Purse[Nickel, Dime, Penny, Half-dollar]

v: Purse[Quarter, Dime, Nickel]
w: Purse[Quarter, Dime, Nickel]
x: Purse[Quarter, Nickel, Dime]
y: Purse[Quarter]
Is v the same as w? truetrue
Is v the same as x? falsefalse
Is v the same as y? falsefalse

*/
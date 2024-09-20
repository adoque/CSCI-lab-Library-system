
package testing;

import library.Collection;
import library.record.*;
import library.record.Record;
import member.Member;

public class LibraryTester{
    public static void main(String[] args) throws Exception {
        Collection library = new Collection();

        Record book1 = new Book(100, "Green Book", "Steven King");
        Record DVD1 = new DVD(101, "Avengers", "Kevin F", "Fantastic");
        Record Music1 = new MusicCD(102, "Dante", "Toxis", "Rap");

        Member member1 = new Member(1000, "Adlet", "Dautbek");
        Member member2 = new Member(1001, "Azamat", "Myrzagali");

        library.addMember(member1);
        library.addMember(member2);
        member1.borrowId(101);
        System.out.println(member1);
        member1.borrowId(102);
        System.out.println(member1);
        member2.borrowId(100);
        System.out.println(member2);
        System.out.println(book1);
        System.out.println(DVD1);
        System.out.println(Music1);
        member1.returnId(101);
        System.out.println(member1);
        member1.borrowId(100);
        System.out.println(library);
    }
}


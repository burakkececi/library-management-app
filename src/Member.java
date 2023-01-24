import java.util.Objects;

public class Member {

    private String id;
    private String name;
    private String email;

    public Member(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Member(Member oldMember){
        if(oldMember != null){
            this.id = oldMember.id;
            this.name = oldMember.name;
            this.email = oldMember.email;
        }
        System.out.println("Fatal Error: Creating copy constructor within Member Class.");
        System.exit(0);
    }

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id.equals(member.id) && name.equals(member.name) && email.equals(member.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}

package africa.semicolon.phoneBook.data.dto;

public class RegisterContactResponse {
    private  String fullName;
    private String mobile;


    public void setFullName(String fullName) {
        this.fullName = fullName;
        
    }

    public String getFullName() {
        return  fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

package quanlydoannhanh;

public class DisplayValueModel {

    public Object displayMember;
    public Object valueMember;

    public DisplayValueModel(Object display, Object value) {
        displayMember = display;
        valueMember = value;
    }

    public DisplayValueModel(String SP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return displayMember.toString();
    }
}

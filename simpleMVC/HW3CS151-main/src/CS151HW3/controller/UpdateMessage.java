package CS151HW3.controller;


import CS151HW3.controller.Message;

public class UpdateMessage implements Message {
    private String r;
    private String g;
    private String b;

    public UpdateMessage(String str, String str1, String str2) {
        this.r = str;
        this.g = str1;
        this.b = str2;
    }

    public String getRNumber() {
        if(Integer.valueOf(r)>=0)
        {
            return r;
        }
        else
        {
           return "0";
        }
    }

    public String getGNumber() {
        if(Integer.valueOf(g)>=0)
        {
            return g;
        }
        else
        {
            return "0";
        }
    }

    public String getBNumber() {
        if(Integer.valueOf(b)>=0)
        {
            return b;
        }
        else
        {
            return "0";
        }
    }
}



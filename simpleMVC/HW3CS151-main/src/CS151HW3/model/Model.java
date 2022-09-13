package CS151HW3.model;



public class Model {
    private String rnum;
    private String gnum;
    private String bnum;

    public void setRedNum(String rNum) {
        if(Integer.valueOf(rNum)>=0)
        {
            this.rnum = rNum;
        }
        else
        {
            this.rnum = "0";
        }


    }

    public String getRNum()
    {
        return rnum;
    }

    public void setGreenNum(String gNum) {

        if(Integer.valueOf(gNum)>=0)
        {
            this.gnum = gNum;
        }

    }

    public String getGNum()
    {
        return gnum;
    }

    public void setBlueNum(String bNum) {

        if(Integer.valueOf(bNum)>=0)
        {
            this.bnum = bNum;
        }

    }

    public String getBNum()
    {
        return bnum;
    }



}

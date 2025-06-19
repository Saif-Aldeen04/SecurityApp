package Java.securityApp;


    /*
     * author: Saif Aldeen Wael
     * date: 22/1/2025
     * function: To create password using your data to make password easy to remember for you
     */


public class Password{

    private String name;
    private String birthday;
    private String password = "";

    //Defualt constractor.
    Password(){}

    //Constractor to take name and birthday.
    Password(String name,String birthday){
        this.name = name;
        this.birthday = birthday;
    }

    //This function to get the name.
    public String getName(){
        return name;
    }

    //This function to get the birhtday.
    public String getBirthday(){
        return birthday;
    }

    //This function to get the password.
    public String getPassword(){
        return password;
    }

    //This function to set the name.
    public void setName(String name){
        this.name = name;
    }

    //This function to set the birhtday.
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    // To detect the sequence of the pssword.
    // The password should be 4 sectors:
    // 1 --> speatial characters.
    // 2 --> numbers.
    // 3--> Upper cases.
    // 4--> Lower cases.
    private static int detectSeq(){
        
        int[] seq = {1234,2134,3214}; // The avaliable sequences.

        // To choose random sequence.
        int choose = (int)(Math.random() * 3);

        return seq[choose];
    }

    // This function to make password.
    public void createPassword(){

        String Symbols = new String("@#$&%/*"); // The avaliable speatial characters.
        int choice = detectSeq(); // To call function to choose the sequence of password.
        int b_1,b_2,b_3,b_4,e_1,e_2,e_3,e_4; // b_1 --> The beginng of the sector number 1.
                                             // e_1 --> The end of the sector number 1. and so on.

                // These 4 lines to choose the length of each sector.
                int a = 2 + (int)(Math.random() * 2);
                int b = 2 + (int)(Math.random() * 2);
                int c = 2 + (int)(Math.random() * 2);
                int d = 12 - a - b - c;

            // To assign the beginngs and ends of sectors.
            // 1234 --> speatial characters + numbers + upper cases + lower cases.
            if(choice == 1234){
                b_1 = 0;
                e_1 = (a - 1);
                b_2 = a;
                e_2 = (a + b - 1);
                b_3 = a + b;
                e_3 = (a + b + c - 1);
                b_4 = a + b + c;
                e_4 = (a + b + c + d - 1);
            }else if(choice == 2134){ // 2134 --> numbers + speatial characters + upper cases + lower cases.
                b_1 = a;
                e_1 = (a + b - 1);
                b_2 = 0;
                e_2 = (a - 1);
                b_3 = a + b;
                e_3 = (a + b + c - 1);
                b_4 = a + b + c;
                e_4 = (a + b + c + d - 1);
            }else{ // The reminder is 3214 --> upper cases + numbers + speatial characters + lower cases.
                b_1 = a + b;
                e_1 = (a + b + c - 1);
                b_2 = a;
                e_2 =(a + b - 1);
                b_3 = 0;
                e_3 = (a - 1);
                b_4 = a + b + c;
                e_4 = (a + b + c + d - 1);
            }
            
            // This loop make the password 12 characters.
            for(int i = 0; i < 12; i++){

                //This condition for add at least two speatial characters.
                if(i >= b_1 && i <= e_1){
                    
                    int index = (int)(Math.random() * Symbols.length());

                    password = password.concat(Symbols.charAt(index) + "");
                }

                //This condition for add at least two digits of numbers.
                if(i >= b_2 && i <= e_2){
                    
                    int index = (int)(Math.random() * birthday.length());

                    password = password.concat(birthday.charAt(index) + "");
                }

                //This condition for add at least two Upper cases.
                if(i >= b_3 && i <= e_3){
                    
                    int index = (int)(Math.random() * name.length());

                    password = password.concat((name.charAt(index) + "").toUpperCase());
                }
                
                //This condition for add at least two Lower cases.
                if(i >= b_4 && i <= e_4){
                    
                    int index = (int)(Math.random() * name.length());

                    password = password.concat((name.charAt(index) + "").toLowerCase());
                }
            }
    }
}
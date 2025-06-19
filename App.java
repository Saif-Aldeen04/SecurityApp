import javax.swing.*;


public class App{
    
    public static boolean repetion = true;

    public static void main(String[] args){

        //to use pic.png as icon instead of built in icons to close message
        ImageIcon icon = new ImageIcon("pic.png");

        //To insert the program introduction window.
        JOptionPane.showMessageDialog(null,"You can press ok to get our services","Welcome Message",JOptionPane.INFORMATION_MESSAGE, icon);
        
        
        //this loop makes program work unless you choose "exit" or press close icon above the right of program 
        while(true){
            
            menu();

            if (!repetion) {
                
                JOptionPane.showMessageDialog(null,"Thanks for using our Application","Exit",JOptionPane.INFORMATION_MESSAGE, icon);
                break;
            }
        }

    }

    /*
     * author: Saif Aldeen Wael
     * date: 13/1/2025
     * function: To choose the avaliable service
     */

    public static void menu(){

        int choice;
            //This window to show your the avaliable service.
            String strChoice = JOptionPane.showInputDialog("1.Encrypte message.\n2.Decrypte message.\n3.Create password.\n4.exit.");
            choice = Integer.parseInt(strChoice);

                //This switch case to do what you want.
                switch(choice){
            
                    case 1:
                        encrypteMessage();
                    break;
            
                    case 2:
                        decrypteMessage();
                    break;

                    case 3:
                        newPassword();
                    break;

                    case 4:
                    //if you press 4 to exit make this boolean variable flase to break loop in line 19.
                        repetion = false;
                    return; 

                    default:menu();
                }

    }

    /*
     * author: Saif Aldeen Wael
     * date: 11/1/2025
     * function: To encrypte any message by declareing object form Encryption class
     */
    
    public static void encrypteMessage(){

        int key = -1;
        String needKey;
         
            //do while loop for do the encryption proccess once at least.
            do{
                //To know you want speacial key or you want use the default key.
                needKey = JOptionPane.showInputDialog("Are you need key?(y/n)\n" + 
                                        "(if you say no you will use default key = 3)");

                //This if condition to check your answer about key question if you choose y,n,yes or no the loop will break.
                if (needKey.equals("y")  || needKey.equals("Y") || needKey.equals("n") || needKey.equals("N")) {
                    break;
                }

            }while(true);


                if(needKey.equals("y")  || needKey.equals("Y")){

                    //srtkey variable to take your new key and the next line to casting the key to integer.
                    while(true){
                        String strKey = JOptionPane.showInputDialog("What is your key?");
                        key = Integer.parseInt(strKey);
                        
                        if(key > 0){
                            break;
                        }
                    }

                    //here you can input your massage to encrypte it and casting it to stringbuilder to make editing on it easy.
                    String strMessage = JOptionPane.showInputDialog("Enter the message you want encrypte:");
                    StringBuilder message = new StringBuilder(strMessage);

                    //Here the program declareing new object form Encryption class and pass the message and key to it to make its function.
                    Encryption E1 = new Encryption(message,key);
                    E1.encryptionMessage(message,key);

                    //This window to show user the encrypted message.
                    JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(new String(E1.getMessage())) {{ setEditable(false); }}), "The encryption message with key "+E1.getKey()+" is", JOptionPane.INFORMATION_MESSAGE);
                
                    
            
                }else{

                    //In this case you will use the default key that is equal 3 so the program pass only message to Encryption class
                    String strMessage = JOptionPane.showInputDialog("Enter the message you want encrypte:");
                    StringBuilder message = new StringBuilder(strMessage);

                    //Here the program declareing new object form Encryption class and pass the message and key to it to make its function.
                    Encryption E1 = new Encryption(message);
                    E1.encryptionMessage(message);
                
                    //This window to show user the encrypted message.
                    JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(new String(E1.getMessage())) {{ setEditable(false); }}), "The encryption message with key 3 is", JOptionPane.INFORMATION_MESSAGE);

                } 
    }


    /*
     * author: Saif Aldeen Wael
     * date: 16/1/2025
     * function: To decrypte any message by identifing object form Decryption class
     */


    public static void decrypteMessage(){

        int key;
        String needKey;
         
            //do while loop for do the encryption proccess once at least.
            do{

                //To know you want speacial key or you want use the default key.
                needKey = JOptionPane.showInputDialog("Do you have a key?(y/n)\n" + 
                                        "(if you say no you will use default key = 3)");

                //This if condition to check your answer about key question if you choose y,n,yes or no the loop will break.
                if (needKey.equals("y")  || needKey.equals("Y") || needKey.equals("n") || needKey.equals("N")) {
                    break;
                }

            }while(true);
        
        
            if(needKey.equals("y")  || needKey.equals("Y")){
                
                //srtkey variable to take your new key and the next line to casting the key to integer.
                while(true){
                    String strKey = JOptionPane.showInputDialog("What is your key?");
                    key = Integer.parseInt(strKey);
                    
                    if(key > 0){
                        break;
                    }
                }

                //here you can input your massage to encrypte it and casting it to stringbuilder to make editing on it easy.
                String strMessage = JOptionPane.showInputDialog("Enter the message you want decrypte:");
                StringBuilder message = new StringBuilder(strMessage);

                //Here the program declareing new object form Dencryption class and pass the message and key to it to make its function.
                Decryption E1 = new Decryption(message,key);
                E1.decryptionMessage(message,key);

                //This window to show user the dencrypted message.
                JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(new String(E1.getMessage())) {{ setEditable(false); }}), "The decryption message with key "+E1.getKey()+" is", JOptionPane.INFORMATION_MESSAGE);
            
                
        
            }else{

                //In this case you will use the default key that is equal 3 so the program pass only message to Encryption class.
                String strMessage = JOptionPane.showInputDialog("Enter the message you want decrypte:");
                StringBuilder message = new StringBuilder(strMessage);

                //Here the program declareing new object form Dencryption class and pass the message and key to it to make its function.
                Decryption E1 = new Decryption(message);
                E1.decryptionMessage(message);
            
                //This window to show user the dencrypted message.
                JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(new String(E1.getMessage())) {{ setEditable(false); }}), "The decryption message with key 3 is", JOptionPane.INFORMATION_MESSAGE);
            }
        }


        /*
         * author: Saif Aldeen Wael
         * date: 21/2/2025
         * function: To create new password for you depend on your data to make it easy for you.
         */


        public static void newPassword(){

            //The windows in the next two lines to take your name and birthday.
            String name = JOptionPane.showInputDialog("Enter your name: ");
            String birthday = JOptionPane.showInputDialog("Enter your birthday: like(ddmmyyyy->04032004)");

            //The program use the deleteSpaces function to delete all white spaces in String.
            String newName = deleteSpaces(name);
            String newBirthday = deleteSpaces(birthday);

            //Here the program declearing new object from Password class and pass name and birthday to it from constractor
            Password password = new Password(newName,newBirthday);

            //Here the program user createPassword function to create strong password contain speacial characters,numbers,capital characters and small characters.
            password.createPassword();

            //TO show your strong password in output window.
            JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(new String(password.getPassword())) {{ setEditable(false); }}), "Your new password", JOptionPane.INFORMATION_MESSAGE);



        }


        /*
         * author: Saif Aldeen Wael
         * date: 21/2/2025
         * function: To delete all spaces in any variable.
         */


        public static String deleteSpaces(String oldName){

            String newName = "";
            
                //This loop from zero index to last character in oldName
                for(int i = 0; i < oldName.length(); i++){
                    
                    //This condition to add all characters to newName except white spaces
                    if(oldName.charAt(i) == ' '){
                        continue;
                    }else{
                        newName += oldName.charAt(i) + "";
                    }
                }

                //The function returns string == parameter without white spaces.
            return newName;
        }
}

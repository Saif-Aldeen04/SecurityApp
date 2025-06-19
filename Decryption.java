package Java.securityApp;


    /*
     * author: Saif Aldeen Wael
     * date: 15/1/2025
     * function: To decrypte any message you want with key you want or with default key
     */

     
public class Decryption {

    private StringBuilder message;
    private int key = 3;
    
    //Defualt constractor.
    Decryption(){}

    //Constractor to Take only message.
    Decryption(StringBuilder message){
        this.message = message;
    }

    //Constractor to take message and key.
    Decryption(StringBuilder message, int key){
        this.message = message;
        this.key = key;
    }
    
    //This function to get the message.
    public StringBuilder getMessage(){
        return message;
    }

    //This function to set message.
    public void setMessage(StringBuilder message){
        this.message = message;
    }

    //This function to get the key.
    public int getKey(){
        return key;
    }

    //This function to set the key.
    public void setKey(int key){
        this.key = key;
    }

    //This function to decrypte any message with specific key.
    public void decryptionMessage(StringBuilder message,int key){
        
         //length --> of the message to change every character.
        int length = message.length();
        boolean capital = false;

        for(int i = 0; i < length; i++){

            int tempNum;
            char tempChar;

            //tempnum to carry the value of ASCII code of the character.
            tempNum = message.charAt(i);

            //To detect if the character is small of Capital.
            if(tempNum >= 97 && tempNum <= 122){
                capital = false;
            }else if(tempNum >= 65 && tempNum <= 90){
                capital = true;
            }
            
            //To skip all white spaces.
            if(tempNum == 32){
                continue;
            }

            //This line to calculate the new ASCII code of the original charater.
            tempNum -= key;
            
            //The 2 block to still in the range of characters.
            if(tempNum < 97 && !capital){
                while(tempNum < 97){
                    tempNum += 26;
                }
            }
            
            if(tempNum < 65 && capital){
                while(tempNum < 65){
                    tempNum += 26;
                }
            }
            
            //tempChar --> to carry new character.
            tempChar = (char)tempNum;

            //This line to replace the the original character with the new character.
            message.replace(i,i+1,tempChar+"");
        }

        this.message = message;
        this.key = key;
    }

    //This function to decrypte any message with key = 3.
    public void decryptionMessage(StringBuilder message){
        
        //length --> of the message to change every character.
        int length = message.length();
        boolean capital = false;

        for(int i = 0; i < length; i++){

            int tempNum;
            char tempChar;

            //tempnum to carry the value of ASCII code of the character.
            tempNum = message.charAt(i);

            //To detect if the character is small of Capital.
            if(tempNum >= 97 && tempNum <= 122){
                capital = false;
            }else if(tempNum >= 65 && tempNum <= 90){
                capital = true;
            }

            //To skip all white spaces.
            if(tempNum == 32){
                continue;
            }

            //This line to calculate the new ASCII code of the original charater.
            tempNum -= key;
            
            //The 2 block to still in the range of characters
            if(tempNum < 97 && !capital){
                while(tempNum < 97){
                    tempNum += 26;
                }
            }
            
            //tempChar --> to carry new character.
            if(tempNum < 65 && capital){
                while(tempNum < 65){
                    tempNum += 26;
                }
            }
            
            //tempChar --> to carry new character.
            tempChar = (char)tempNum;
            
            //This line to replace the the original character with the new character.
            message.replace(i,i+1,tempChar+"");
        }

        this.message = message;
    }
}
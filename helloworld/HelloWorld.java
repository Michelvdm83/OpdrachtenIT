/*
Prints Hello, world!
Everyone's first program
*/
package helloworld;

import LichtAan.LichtAan;

public class HelloWorld{
    public static void main(String[] args){
        //just say Hello
        System.out.println("Hello, world!");
        if(args.length > 0){
            for(int i = 0; i < args.length; i++){
                System.out.println(args[i]);
            }
        }
		LichtAan.main(args);
    }
}
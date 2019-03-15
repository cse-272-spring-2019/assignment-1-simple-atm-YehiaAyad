

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yehia
 */

public class All{

    /**
     *
     */
   private float balance;
int c=0;
int p=0;

    public int getC() {
        return c;
    }
 String his[]=new String [5];

    
String cardnumber;
 final String passcode="4444";
layout mo=new layout();

 public All() {
        this.balance = 0;
    }
 void deposit(float amount){
  this.balance =amount+this.balance;
    
  if (c==5)
  {
      for(int i=0;i<4;i++)
          his[i]=his[i+1];
      c=4;
  }
  if(p==5)
      p=4;

  his[c]="Desposit: "+amount;
  c++;
  p++;
 }

 public boolean withdraw(float amount){
     if(amount>this.balance)
      return false;
     else
     {this.balance = this.balance - amount;
    if (c==5)
  {
      for(int i=0;i<4;i++)
          his[i]=his[i+1];
      c=4;
  }
    if(p==5)
        p=4;

  his[c]="Withdraw: "+amount;
  c++;
  p++;
    return true;
     }
     
 }
public float getbalance(){
    return balance;
 }


public String next()
{  String s=new String();

    if(p<4){
    p++;
    
    s=this.his[p];
    }
    
    
   return s; 
}

public String prev()
        
{  
    String s=new String();
    if(p>0){
    p--;
    
    s=this.his[p];
    
    }
    
   return s; 
}


 public String present(String mn)
 {if(mn != null && mn.length() != 0)
     return mn+"\n";
 else 
     return "";
     }
  }

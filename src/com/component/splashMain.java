
package com.component;

public class splashMain {
    public static void main(String args[]){
        splash2 sp = new splash2();
                    sp.setVisible(true);
     
     try{
            for(int i=0; i<=100;i++){
            
                        Thread.sleep(100);
                  
                sp.LoadingValue.setText(i+" %");
                if(i==10){
                   sp.LoadingLabel.setText("Cargando Módulos...");
                }
                  if(i==25){
                    sp.LoadingLabel.setText("Iniciando...");
                  
                   //  ms.setVisible(true);
                    
                }
                  if(i==100){
                    sp.LoadingLabel.setText("Cargandando...");
                    
                  
                    
                }
                 sp.PBar.setValue(i);
            }
     }catch(Exception e){
                
            }
    }
}

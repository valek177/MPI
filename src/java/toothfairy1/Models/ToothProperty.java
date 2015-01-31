/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Models;

/**
 *
 * @author Николай
 */
public class ToothProperty {
    public String label;
		public String value;
 
		public ToothProperty(String label, String value){
			this.label = label;
			this.value = value;
		}
 
		public String getLabel(){
			return label;
		}
 
		public String getValue(){
			return value;
		}
}

package org.example.language_fundamentals;

public class JavaCodingStandards {


    /*
      Package Naming Conventions: all small case
      companyname.projectname.module // com.tradein.invoice

      class name / interface  conventions: pascal case starts with CAPITAL letter >>  first letter of each word is UpperCase //CamelCase
      class name >> meaningful >> display overall functionality

      declare method as Static >> if not using any instance variables

      method name >> starts with LOWER case >> for rest  first letter of each word is UpperCase //camelCase
      method name >> meaningful >> display specific functionality

      variable name >> starts with LOWER case >> for rest  first letter of each word is UpperCase //camelCase
      name should display what it stores, in layman language

      constant name >> all upper case >> words separated by underscore >> MAX_VALUE , MAX_PRIORITY

      Bean

      private members , public getters , public setter | starts with  get/set
      *** for boolean use is_Empty


      listeners >> starts with on_ >> onClick, onChange, onSubmit
      listens events ex. mouse click, key press, form submit etc. , listen and perform event handling
      name >> starts with LOWER case >> for rest  first letter of each word is UpperCase //camelCase
              ex. addMouseListener, addKeyListener, addActionListener
      ** Argument >> just remove add from method name
      REGISTER
              public void addMouseListener(MouseListener listener) {
                  // code to add mouse listener
              }
     DEREGISTER
              public void removeMouseListener(MouseListener listener) {
                  // code to add mouse listener
              }
    * */
}

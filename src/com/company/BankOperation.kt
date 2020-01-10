package com.company

class BankOperation {

    var Name = ArrayList<String>()
    var AccountNo = ArrayList<String>()
    var Balance = ArrayList<String>()


    //--------------- Function to Show Menu for Selection ----------------//
    fun ShowMenu(){

       println("\nPlease Select Option Below:");
       println("1- Create Account");
       println("2- Withdraw Amount");
       println("3- Deposit Amount");
       println("4- Show Account Details");

        var option = readLine();
        if (option != null) {
            if (option.matches("-?\\d+(\\.\\d+)?".toRegex())){
                OptionSelection(Integer.parseInt(option));
            }else{
                println("Please Enter Any No.");
                ShowMenu();
            }
        }

    }


    //--------------- Function to Handle Option from User Input ----------------//
   private fun OptionSelection(a: Int){

       when(a){
           1 -> CreateAccount();
           2 -> Withdraw();
           3 -> Deposit();
           4 -> ShowAccountDetails()
           else -> {ShowMenu()}
       }
    }


    //--------------- Function to Create an Account and Store data in Array List ----------------//
    private  fun CreateAccount(){
        println("Enter Your Full Name");
        Name.add(readLine().toString());
        println("Enter Your Account No");
        AccountNo.add(readLine().toString());
        println("Enter Initial Amount");
        Balance.add(readLine().toString());
        println("\n---Your Account has been created successfully---\n");

        ShowMenu();
    }

    //--------------- Function to Withdraw amount from your account no if your balance is greater than amount you will entered ----------------//
    private fun Withdraw(){
        println("Enter Amount to Withdraw");
        var amount = Integer.parseInt(readLine());
        println("Enter Account No");
        var accountNo = readLine();

        for (i in 0..AccountNo.size-1){
            if (accountNo.equals(AccountNo.get(i.toInt()))){
                var balance = Balance.get(i.toInt());
                if (Integer.parseInt(balance) > amount){
                    Balance.set(i , (Integer.parseInt(balance) -  amount).toString())
                    println("\n Now your Balance is "+Balance.get(i))
                    ShowMenu();
                }else{
                    println("\nYour Balance should greater than Amount you Entered!")
                    ShowMenu();
                }

            }
        }
        println("\nAccount Not Found!")
        ShowMenu();
    }


    //--------------- Function to Deposit amount into your account no  ----------------//
    private fun Deposit(){
        println("Enter Amount to Deposit");
        var amount = Integer.parseInt(readLine());
        println("Enter Account No");
        var accountNo = readLine();

        for (i in 0..AccountNo.size-1){
            if (accountNo.equals(AccountNo.get(i.toInt()))){
                var balance = Balance.get(i.toInt());

                    Balance.set(i , (Integer.parseInt(balance) +  amount).toString())
                    println("\n Now your Balance is " + Balance.get(i))
                    ShowMenu();

            }
        }
        println("\nAccount Not Found!")
        ShowMenu();
    }


    //--------------- Function to Show Account Details on behalf of Account No if Exist ----------------//
    private fun ShowAccountDetails(){
        println("Please Enter Account No:")
        var accountNo = readLine();

        for (i in 0..AccountNo.size-1){
            if (accountNo.equals(AccountNo.get(i.toInt()))){
                println("\nAccount Name is: "+Name.get(i.toInt()));
                println("Account Number is: "+AccountNo.get(i.toInt()));
                println("Account Balance is: "+Balance.get(i.toInt()));
                ShowMenu();
            }
        }
        println("\nAccount Not Found!")
        ShowMenu();
    }
}
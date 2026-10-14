class pgm1 {
    final void display1() {
        System.out.println("Method of pgm1 display 1");
    }
}

void display2(){
        System.out.println("Inside the pgm display 2")
    }

class Final {
    public static void main(String args){
        pgm2 p2 = new pgm2()

        p2.display1();
        p2.display2();
    }
}

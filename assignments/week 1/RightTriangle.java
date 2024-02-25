public class RightTriangle {
    public static void main(String[] args) {
        boolean isRightTriangle;
        int side1 = Integer.parseInt(args[0]);
        int side2 = Integer.parseInt(args[1]);
        int side3 = Integer.parseInt(args[2]);
        isRightTriangle = (side1 > 0) && (side2 > 0) && (side3 > 0);
        isRightTriangle = isRightTriangle && (((side1*side1 + side2*side2) == side3*side3) || ((side1*side1 + side3*side3) == side2*side2) || ((side3*side3 + side2*side2) == side1*side1));
        
        System.out.println(isRightTriangle);
    }    
}

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int horizontalMove = 0, verticalMove = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U')
                verticalMove += 1;
            else if (moves.charAt(i) == 'D')
                verticalMove -= 1;
            else if (moves.charAt(i) == 'L')
                horizontalMove += 1;
            else
                horizontalMove -= 1;
        }

        return horizontalMove == 0 && verticalMove == 0;
    }
}

abstract class ChessPiece
{
    abstract void move(int startRow, int startCol,
                       int endRow, int endCol);


}
final class Bishop extends ChessPiece
{
    @Override
    final void move(final int startRow,
              final int startCol,
              final int endRow,
              final int endCol)
    {
        System.out.println("move like bishop");
    }

    void move()
    {

    }
}
class Rook extends ChessPiece
{
    @Override
    void move(final int startRow,
              final int startCol,
              final int endRow,
              final int endCol)
    {
        System.out.println("move like rook");
    }
}
class Main
{
    public static void main(final String[] args)
    {
        final ChessPiece rook;
        final ChessPiece bishop;

        rook   = new Rook();
        bishop = new Bishop();

        rook.move(1,2,3,4 );
        bishop.move(1,2,3,4);
    }
}
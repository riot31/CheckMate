package com.springapp.mvc.boot.board;

/**
 * Created by o.lutsevich on 7.7.16.
 */

//TODO добавить рокировку и возможность бить пешку как-будто она походила на 1 ход(воо,щем сделать игру по правилам)
//TODO пешки никогда не станут королевами

public class MoveUtil {
    private static final int EMPTY_POLE_FLAG = 0;
    private static final int DIFFERENCE_COLOR = 10;

    private static int[] movePawn(int[] board, Item pawn) {
        int pos = pawn.getPosition();
        int x = pos / 8;
        int y = pos % 8;

        int[] result = buildDefaultArray(4);
        if (x == 0 || x == 7) {
            return result;
        }
        int resultCount = 0;

        if (pawn.getValue() > DIFFERENCE_COLOR) {
            if (x == 1) {
                int tmp = checkMove(board, (x + 2) * 8 + y, true);
                if (tmp == 0) {
                    result[resultCount++] = (x + 2) * 8 + y;
                }
            }
            if (y < 7) {
                int tmp = checkMove(board, (x + 1) * 8 + y + 1, true);
                if (tmp == 1) {
                    result[resultCount++] = (x + 1) * 8 + y + 1;
                }
            }
            if (y > 0) {
                int tmp = checkMove(board, (x + 1) * 8 + y - 1, true);
                if (tmp == 1) {
                    result[resultCount++] = (x + 1) * 8 + y - 1;
                }
            }
            int tmp = checkMove(board, (x + 1) * 8 + y, true);
            if (tmp == 0) {
                result[resultCount] = (x + 1) * 8 + y;
            }
        } else {
            if (x == 6) {
                int tmp = checkMove(board, (x - 2) * 8 + y, true);
                if (tmp == 0) {
                    result[resultCount++] = (x - 2) * 8 + y;
                }
            }
            if (y < 7) {
                int tmp = checkMove(board, (x - 1) * 8 + y + 1, true);
                if (tmp == 1) {
                    result[resultCount++] = (x - 1) * 8 + y + 1;
                }
            }
            if (y > 0) {
                int tmp = checkMove(board, (x - 1) * 8 + y - 1, true);
                if (tmp == 1) {
                    result[resultCount++] = (x - 1) * 8 + y - 1;
                }
            }
            int tmp = checkMove(board, (x - 1) * 8 + y, true);
            if (tmp == 0) {
                result[resultCount] = (x - 1) * 8 + y;
            }
        }
        return result;
    }

    private static int[] moveCastle(int[] board, Item castle) {
        int pos = castle.getPosition();
        int x = pos / 8;
        int y = pos % 8;
        int[] result = buildDefaultArray(14);
        int resultCount = 0;
        boolean isBlack = castle.getValue() > DIFFERENCE_COLOR;
        for (int i = 1; i < 8; i++) {
            if (x + i < 8) {
                int stroke = (x + i) * 8 + y;
                int tmp = checkMove(board, stroke, isBlack);
                if (tmp == 0) {
                    result[resultCount] = stroke;
                    resultCount++;
                } else if (tmp == 1) {
                    result[resultCount] = stroke;
                    resultCount++;
                    break;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (x - i >= 0) {
                int stroke = (x - i) * 8 + y;
                int tmp = checkMove(board, stroke, isBlack);
                if (tmp == 0) {
                    result[resultCount] = stroke;
                    resultCount++;
                } else if (tmp == 1) {
                    result[resultCount] = stroke;
                    resultCount++;
                    break;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (y - i >= 0) {
                int stroke = x * 8 + y - i;
                int tmp = checkMove(board, stroke, isBlack);
                if (tmp == 0) {
                    result[resultCount] = stroke;
                    resultCount++;
                } else if (tmp == 1) {
                    result[resultCount] = stroke;
                    resultCount++;
                    break;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (y + i < 8) {
                int stroke = x * 8 + y + i;
                int tmp = checkMove(board, stroke, isBlack);
                if (tmp == 0) {
                    result[resultCount] = stroke;
                    resultCount++;
                } else if (tmp == 1) {
                    result[resultCount] = stroke;
                    break;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private static int[] moveKnight(int[] board, Item knight) {
        int pos = knight.getPosition();
        int x = pos / 8;
        int y = pos % 8;

        int[] result = buildDefaultArray(8);
        int resultCount = 0;

        boolean isBlack = knight.getValue() > DIFFERENCE_COLOR;

        if (x > 1 && y > 0) {
            if (checkMove(board, (x - 2) * 8 + y - 1, isBlack) >= 0) {
                result[resultCount] = (x - 2) * 8 + y - 1;
                resultCount++;
            }
        }
        if (x > 1 && y < 7) {
            if (checkMove(board, (x - 2) * 8 + y + 1, isBlack) >= 0) {
                result[resultCount] = (x - 2) * 8 + y + 1;
                resultCount++;
            }
        }
        if (x > 0 && y > 1) {
            if (checkMove(board, (x - 1) * 8 + y - 2, isBlack) >= 0) {
                result[resultCount] = (x - 1) * 8 + y - 2;
                resultCount++;
            }
        }
        if (x > 0 && y < 6) {
            if (checkMove(board, (x - 1) * 8 + y + 2, isBlack) >= 0) {
                result[resultCount] = (x - 1) * 8 + y + 2;
                resultCount++;
            }
        }
        if (x < 6 && y > 0) {
            if (checkMove(board, (x + 2) * 8 + y - 1, isBlack) >= 0) {
                result[resultCount] = (x + 2) * 8 + y - 1;
                resultCount++;
            }
        }

        if (x < 6 && y < 7) {
            if (checkMove(board, (x + 2) * 8 + y + 1, isBlack) >= 0) {
                result[resultCount] = (x + 2) * 8 + y + 1;
                resultCount++;
            }
        }
        if (x < 7 && y > 1) {
            if (checkMove(board, (x + 1) * 8 + y - 2, isBlack) >= 0) {
                result[resultCount] = (x + 1) * 8 + y - 2;
                resultCount++;
            }
        }
        if (x < 7 && y < 6) {
            if (checkMove(board, (x + 1) * 8 + y + 2, isBlack) >= 0) {
                result[resultCount] = (x + 1) * 8 + y + 2;
            }
        }
        return result;
    }

    private static int[] moveBishop(int[] board, Item bishop) {
        int pos = bishop.getPosition();
        int x = pos / 8;
        int y = pos % 8;
        int[] result = buildDefaultArray(13);
        int resultCount = 0;
        boolean isBlack = bishop.getValue() > DIFFERENCE_COLOR;
        for (int i = 1; i < 8; i++) {
            if (x - i >= 1 && y - i >= 0) {
                int tmp = checkMove(board, (x - i) * 8 + y - i, isBlack);
                if (tmp == 0) {
                    result[resultCount] = (x - i) * 8 + y - i;
                    resultCount++;
                } else if (tmp == 1) {
                    result[resultCount] = (x - i) * 8 + y - i;
                    resultCount++;
                    break;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (x + i <= 7 && y + i <= 7) {
                int tmp = checkMove(board, (x + i) * 8 + y + i, isBlack);
                if (tmp == 0) {
                    result[resultCount] = (x + i) * 8 + y + i;
                    resultCount++;
                } else if (tmp == 1) {
                    result[resultCount] = (x + i) * 8 + y + i;
                    resultCount++;
                    break;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (x - i >= 0 && y + i <= 7) {
                int tmp = checkMove(board, (x - i) * 8 + y + i, isBlack);
                if (tmp == 0) {
                    result[resultCount] = (x - i) * 8 + y + i;
                    resultCount++;
                } else if (tmp == 1) {
                    result[resultCount] = (x - i) * 8 + y + i;
                    resultCount++;
                    break;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (x + i <= 7 & y - i >= 0) {
                int tmp = checkMove(board, (x + i) * 8 + y - i, isBlack);
                if (tmp == 0) {
                    result[resultCount] = (x + i) * 8 + y - i;
                    resultCount++;
                } else if (tmp == 1) {
                    result[resultCount] = (x + i) * 8 + y - i;
                    break;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private static int[] moveQueen(int[] board, Item queen) {
        int[] castle = moveCastle(board, queen);
        int[] bishop = moveBishop(board, queen);
        int[] result = buildDefaultArray(27);
        int resultCount = 0;
        for (int aCastle : castle) {
            if (aCastle == -1) {
                break;
            } else {
                result[resultCount] = aCastle;
                resultCount++;
            }
        }
        for (int aBishop : bishop) {
            if (aBishop == -1) {
                break;
            } else {
                result[resultCount] = aBishop;
                resultCount++;
            }
        }
        return result;
    }

    private static int[] moveKing(int[] board, Item king) {
        int pos = king.getPosition();
        int x = pos / 8;
        int y = pos % 8;

        boolean isBlack = king.getValue() > DIFFERENCE_COLOR;

        int[] result = buildDefaultArray(8);
        int resultCount = 0;

        if (x > 0 && y > 0) {
            if (checkMove(board, (x - 1) * 8 + y - 1, isBlack) >= 0) {
                result[resultCount] = (x - 1) * 8 + y - 1;
                resultCount++;
            }
        }

        if (x > 0) {
            if (checkMove(board, (x - 1) * 8 + y, isBlack) >= 0) {
                result[resultCount] = (x - 1) * 8 + y;
                resultCount++;
            }
        }
        if (x > 0 && y < 7) {
            if (checkMove(board, (x - 1) * 8 + y + 1, isBlack) >= 0) {
                result[resultCount] = (x - 1) * 8 + y + 1;
                resultCount++;
            }
        }
        if (y < 7) {
            if (checkMove(board, (x) * 8 + y + 1, isBlack) >= 0) {
                result[resultCount] = (x) * 8 + y + 1;
                resultCount++;
            }
        }
        if (y > 0) {
            if (checkMove(board, (x) * 8 + y - 1, isBlack) >= 0) {
                result[resultCount] = (x) * 8 + y - 1;
                resultCount++;
            }
        }
        if (x < 7 && y > 0) {
            if (checkMove(board, (x + 1) * 8 + y - 1, isBlack) >= 0) {
                result[resultCount] = (x + 1) * 8 + y - 1;
                resultCount++;
            }
        }
        if (x < 7) {
            if (checkMove(board, (x + 1) * 8 + y, isBlack) >= 0) {
                result[resultCount] = (x + 1) * 8 + y;
                resultCount++;
            }
        }

        if (x < 7 && y < 7) {
            if (checkMove(board, (x + 1) * 8 + y + 1, isBlack) >= 0) {
                result[resultCount] = (x + 1) * 8 + y + 1;

            }
        }
        return result;
    }

    private static int checkMove(int[] board, int stroke, boolean isBlack) {
        if (board[stroke] == EMPTY_POLE_FLAG) {
            return 0;
        }
        if (isBlack) {
            if (board[stroke] < 7) {
                return 1;
            }
        } else {
            if (board[stroke] > DIFFERENCE_COLOR) {
                return 1;
            }
        }
        return -1;
    }

    private static int[] buildDefaultArray(int count) {
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = -1;
        }
        return result;
    }

    public static int[] moveItem(int[] board, Item item) {
        if (Figure.PAWN.getIndex().equals(item.getValue() % DIFFERENCE_COLOR)) {
            return movePawn(board, item);
        } else if (Figure.CASTLE.getIndex().equals(item.getValue() % DIFFERENCE_COLOR)) {
            return moveCastle(board, item);
        } else if (Figure.KNIGHT.getIndex().equals(item.getValue() % DIFFERENCE_COLOR)) {
            return moveKnight(board, item);
        } else if (Figure.BISHOP.getIndex().equals(item.getValue() % DIFFERENCE_COLOR)) {
            return moveBishop(board, item);
        } else if (Figure.QUEEN.getIndex().equals(item.getValue() % DIFFERENCE_COLOR)) {
            return moveQueen(board, item);
        } else {
            return moveKing(board, item);
        }
    }
}

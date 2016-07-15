package com.springapp.mvc.boots.board;

import org.apache.commons.lang.ArrayUtils;

/**
 * Created by o.lutsevich on 7.7.16.
 */

//TODO добавить рокировку и возможность бить пешку как-будто она походила на 1 ход(воо,щем сделать игру по правилам)
public class MoveUtil {
    private static final int FIGURE_WHITE_FLAG = 1;
    private static final int FIGURE_BLACK_FLAG = 2;
    private static final int EMPTY_POLE_FLAG = 0;
    private static int[] movePawn(int[] board, Item pawn) {
        int pos = pawn.getCoordinate();
        int x = pos / 8;
        int y = pos % 8;

        int[] result = buildDefaultArray(4);
        if (x == 0 || x == 7) {
            return result;
        }
        int resultCount = 0;


        if (pawn.isBlack()) {
            if (x == 1) {
                int stroke = (x + 1) * 8 + y;
                if (board[stroke] == EMPTY_POLE_FLAG) {
                    result[resultCount] = stroke;
                    resultCount++;
                    stroke = (x + 2) * 8 + y;
                    if (board[stroke] == EMPTY_POLE_FLAG) {
                        result[resultCount] = stroke;
                        resultCount++;
                    }
                }
            } else if (x < 8) {
                int stroke = (x + 1) * 8 + y;
                if (board[stroke] == EMPTY_POLE_FLAG) {
                    result[resultCount] = stroke;
                    resultCount++;
                }
            }
            if (y > 0 && y < 7) {
                int stroke = (x + 1) * 8 + y - 1;
                if (board[stroke] == FIGURE_WHITE_FLAG) {
                    result[resultCount] = stroke;
                    resultCount++;
                }
                stroke = (x + 1) * 8 + y + 1;
                if (board[stroke] == FIGURE_WHITE_FLAG) {
                    result[resultCount] = stroke;
                }
            } else if (y == 0) {
                int stroke = (x + 1) * 8 + y + 1;
                if (board[stroke] == FIGURE_WHITE_FLAG) {
                    result[resultCount] = stroke;
                }
            } else {
                int stroke = (x + 1) * 8 + y - 1;
                if (board[stroke] == FIGURE_WHITE_FLAG) {
                    result[resultCount] = stroke;
                }
            }
        } else {
            if (x == 6) {
                int stroke = (x - 1) * 8 + y;
                if (board[stroke] == EMPTY_POLE_FLAG) {
                    result[resultCount] = EMPTY_POLE_FLAG;
                    resultCount++;
                    stroke = (x - 2) * 8 + y;
                    if (board[stroke] == EMPTY_POLE_FLAG) {
                        result[resultCount] = stroke;
                        resultCount++;
                    }
                }
            } else if (x > 0) {
                int stroke = (x - 1) * 8 + y;
                if (board[stroke] == EMPTY_POLE_FLAG) {
                    result[resultCount] = EMPTY_POLE_FLAG;
                    resultCount++;
                }
            }
            if (y > 0 && y < 7) {
                int stroke = (x - 1) * 8 + y - 1;
                if (board[stroke] == FIGURE_BLACK_FLAG) {
                    result[resultCount] = stroke;
                    resultCount++;
                }
                stroke = (x - 1) * 8 + y + 1;
                if (board[stroke] == FIGURE_BLACK_FLAG) {
                    result[resultCount] = stroke;
                }
            } else if (y == 0) {
                int stroke = (x - 1) * 8 + y + 1;
                if (board[stroke] == FIGURE_BLACK_FLAG) {
                    result[resultCount] = stroke;
                }
            } else {
                int stroke = (x - 1) * 8 + y - 1;
                if (board[stroke] == FIGURE_BLACK_FLAG)
                    result[resultCount] = stroke;
            }
        }
        return result;
    }


    private static int[] moveCastle(int[] board, Item castle) {
        int pos = castle.getCoordinate();
        int x = pos / 8;
        int y = pos % 8;
        int[] result = buildDefaultArray(14);
        int resultCount = 0;
        for (int i = 1; i < 8; i++) {
            if (x + i < 8) {
                int stroke = (x + i) * 8 + y;
                int tmp = checkMove(board, stroke, castle.isBlack());
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
                int tmp = checkMove(board, stroke, castle.isBlack());
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
                int tmp = checkMove(board, stroke, castle.isBlack());
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
                int tmp = checkMove(board, stroke, castle.isBlack());
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

    //TODO не убегает))
    private static int[] moveKnight(int[] board, Item knight) {
        int pos = knight.getCoordinate();
        int x = pos / 8;
        int y = pos % 8;

        int[] result = buildDefaultArray(8);
        int resultCount = 0;

        if (x > 1 && y > 0) {
            if (checkMove(board, (x - 2) * 8 + y - 1, knight.isBlack()) >= 0) {
                result[resultCount] = (x - 2) * 8 + y - 1;
                resultCount++;
            }
        }
        if (x > 1 && y < 7) {
            if (checkMove(board, (x - 2) * 8 + y + 1, knight.isBlack()) >= 0) {
                result[resultCount] = (x - 2) * 8 + y + 1;
                resultCount++;
            }
        }
        if (x > 0 && y > 1) {
            if (checkMove(board, (x - 1) * 8 + y - 2, knight.isBlack()) >= 0) {
                result[resultCount] = (x - 1) * 8 + y - 2;
                resultCount++;
            }
        }
        if (x > 0 && y < 6) {
            if (checkMove(board, (x - 1) * 8 + y + 2, knight.isBlack()) >= 0) {
                result[resultCount] = (x - 1) * 8 + y + 2;
                resultCount++;
            }
        }
        if (x < 6 && y > 0) {
            if (checkMove(board, (x + 2) * 8 + y - 1, knight.isBlack()) >= 0) {
                result[resultCount] = (x + 2) * 8 + y - 1;
                resultCount++;
            }
        }

        if (x < 6 && y < 7) {
            if (checkMove(board, (x + 2) * 8 + y + 1, knight.isBlack()) >= 0) {
                result[resultCount] = (x + 2) * 8 + y + 1;
                resultCount++;
            }
        }
        if (x < 7 && y > 1) {
            if (checkMove(board, (x + 1) * 8 + y - 2, knight.isBlack()) >= 0) {
                result[resultCount] = (x + 1) * 8 + y - 2;
                resultCount++;
            }
        }
        if (x < 7 && y < 6) {
            if (checkMove(board, (x + 1) * 8 + y + 2, knight.isBlack()) >= 0) {
                result[resultCount] = (x + 1) * 8 + y + 2;
            }
        }
        return result;
    }

    private static int[] moveBishop(int[] board, Item bishop) {
        int pos = bishop.getCoordinate();
        int x = pos / 8;
        int y = pos % 8;
        int[] result = buildDefaultArray(13);
        int resultCount = 0;
        for (int i = 1; i < 8; i++) {
            if (x - i >= 1 && y - i >= 0) {
                int tmp = checkMove(board, (x - i) * 8 + y - i, bishop.isBlack());
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
                int tmp = checkMove(board, (x + i) * 8 + y + i, bishop.isBlack());
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
                int tmp = checkMove(board, (x - i) * 8 + y + i, bishop.isBlack());
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
                int tmp = checkMove(board, (x + i) * 8 + y - i, bishop.isBlack());
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
        return ArrayUtils.addAll(moveCastle(board, queen), moveBishop(board, queen));
    }

    //TODO: king po4emu-to ne ubegaet
    private static int[] moveKing(int[] board, Item king) {
        int pos = king.getCoordinate();
        int x = pos / 8;
        int y = pos % 8;

        int[] result = buildDefaultArray(8);
        int resultCount = 0;

        if (x > 0 && y > 0) {
            if (checkMove(board, (x - 1) * 8 + y - 1, king.isBlack()) >= 0) {
                result[resultCount] = (x - 1) * 8 + y - 1;
                resultCount++;
            }
        }

        if (x > 0) {
            if (checkMove(board, (x - 1) * 8 + y, king.isBlack()) >= 0) {
                result[resultCount] = (x - 1) * 8 + y;
                resultCount++;
            }
        }
        if (x > 0 && y < 7) {
            if (checkMove(board, (x - 1) * 8 + y + 1, king.isBlack()) >= 0) {
                result[resultCount] = (x - 1) * 8 + y + 1;
                resultCount++;
            }
        }
        if (y < 7) {
            if (checkMove(board, (x) * 8 + y + 1, king.isBlack()) >= 0) {
                result[resultCount] = (x) * 8 + y + 1;
                resultCount++;
            }
        }
        if (y > 0) {
            if (checkMove(board, (x) * 8 + y - 1, king.isBlack()) >= 0) {
                result[resultCount] = (x) * 8 + y - 1;
                resultCount++;
            }
        }
        if (x < 7 && y > 0) {
            if (checkMove(board, (x + 1) * 8 + y - 1, king.isBlack()) >= 0) {
                result[resultCount] = (x + 1) * 8 + y - 1;
                resultCount++;
            }
        }
        if (x < 7) {
            if (checkMove(board, (x + 1) * 8 + y, king.isBlack()) >= 0) {
                result[resultCount] = (x + 1) * 8 + y;
                resultCount++;
            }
        }

        if (x < 7 && y < 7) {
            if (checkMove(board, (x + 1) * 8 + y + 1, king.isBlack()) >= 0) {
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
            if (board[stroke] == FIGURE_WHITE_FLAG) {
                return 1;
            }
        } else {
            if (board[stroke] == FIGURE_BLACK_FLAG) {
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
        if (item.getFigure().equals(Figure.KING)) {
            return moveKing(board, item);
        } else if (item.getFigure().equals(Figure.QUEEN)) {
            return moveQueen(board, item);
        } else if (item.getFigure().equals(Figure.BISHOP)) {
            return moveBishop(board, item);
        } else if (item.getFigure().equals(Figure.KNIGHT)) {
            return moveKnight(board, item);
        } else if (item.getFigure().equals(Figure.CASTLE)) {
            return moveCastle(board, item);
        } else {
            return movePawn(board, item);
        }
    }
}

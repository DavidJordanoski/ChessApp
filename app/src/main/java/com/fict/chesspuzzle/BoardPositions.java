package com.fict.chesspuzzle;

import com.github.bhlangonijr.chesslib.File;
import com.github.bhlangonijr.chesslib.Rank;
import com.github.bhlangonijr.chesslib.Square;

public class BoardPositions {
    int x;
    int y;

    void FromSquareToCoordinate(Square square) {
        File file = square.getFile();
        Rank rank = square.getRank();
        System.out.println("You printed " + file + ", " + rank);
    }

    void FromCoordinateToSquare(int x, int y) {
        File fileX = File.allFiles[x];
        Rank rankY = Rank.allRanks[y];
        Square square = Square.encode(rankY, fileX);
        System.out.println("You printed " + square);
    }
}

package com.fict.chesspuzzle;

import com.github.bhlangonijr.chesslib.File;
import com.github.bhlangonijr.chesslib.Rank;
import com.github.bhlangonijr.chesslib.Square;

import java.util.Map;

public class BoardPositions {
    int x;
    int y;

    void FromSquareToCoordinate(String str) {
        x = str.charAt(0) - 'A';
        y = str.charAt(1) - '1';
        System.out.println("You printed " + x + ", " + y);
    }

    void FromCoordinateToSquare(int x, int y) {
        File fileX = File.allFiles[x];
        Rank rankY = Rank.allRanks[y];
        Square square = Square.encode(rankY, fileX);
        System.out.println("You printed " + square);
    }
}

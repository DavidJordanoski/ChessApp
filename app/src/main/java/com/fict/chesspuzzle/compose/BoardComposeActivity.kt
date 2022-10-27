package com.fict.chesspuzzle.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fict.chesspuzzle.models.BoardModel
import com.fict.chesspuzzle.models.SquareModel
import com.fict.myapplication.ui.theme.MyApplicationTheme
import com.github.bhlangonijr.chesslib.File
import com.github.bhlangonijr.chesslib.Rank
import com.github.bhlangonijr.chesslib.Square

//there should be no rules in this class
//only draw what is available in board model
class BoardComposeActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) { //Board()
          //convert the FEN into our Board model
          //kako ke go konvertirame? pa zasega ke koristime biblioteka...

          //Vo druga metoda, mozi da ja vikame usecase
          val board = com.github.bhlangonijr.chesslib.Board() //toj boadr ke go incijalizirame so FEN-ot
          board.loadFromFen("rnbqpbnr/ppp1pppp/8/8/8/PPP2PPP/PPP2PPP/RNB1KBNR w KQkq - 0 1")

          //data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPkAAADKCAMAAABQfxahAAABs1BMVEX///97gX366toAAAD/8+KAhoIA/wD/794AAP99hH//gIBLUU+zp5sdHh07NzP/8tjo6OgqMDD/e3xmbWovNjVQVlSEe3IqLivf0cJ9dGzc3d25raHXybtqYVlHTUtGQDt/hnMgJSIvMecsLuqqn5T9tq5/dm50gX1gWvfIgH9ZU/j/6OaysrJxcXH29vaDg4PR0dG3t7eIiIifn5//6eGr9JWK93iTk5P/+umqqqpENjv/wsLq7Mz169Z2+WfJycle+1L/5+s2/S9t+l9kZGSH93b/+d7R+rag9YtF/Dxa+04gHv7//NVG00dbVE4SGRr/hHfPhXW3q5OEe2NqcF0AANpSw1QA1QAkKACo/6hCPjLWyO3As+ew85qjmO2De/KKgfHuz885EjtA0EGAeILl170+Ij856DoArQAAxACZgX7ugIBlgX1XbGkyTEoALSwfMCv/boZp5DWLzzxlMec4Hh7elI64a2q4gX7FpqtXUVlPVkEOABOEc4caAB0AmLBZO/9dwqMA6kUjpCMkACUZIxKA2G8A4wBec1E2ri5WRFiFanFGXTktLf9ycv/r/+u8/7wlaoA+AAAOrUlEQVR4nOWdjX/aNhrHXYsAKZiYBYcEWhhtmrQpNm/OKFlSeg1Nm14Xtq5Ze7eXXvfWtXvr3Xbbtdtu2/XetnvZ/cknyRbY1gOBYIKJfp9PCeCnsr5IeiTrkWUJJTY2NhJeIQVQu8DZYSltyBZ1DX57QLKKAiWbhpPNSL4psXP9+vWQR4vJGUBa/JLXMBS6tDAP2aKO6c6bOx1bBJnOL0DJZjXINu0j+cb1cDi8vr5+Y8s0TdkWJj/BaVZbjsicQgvzvOmJGcRMI29F32LvQwhI9sT8SohPNhKPzQLJ+k5OtH358tsM3UfynbXo2q1gk4fDu1v+l/ncO9Fo9J25IJInQusM/GLnvL6RRyL3Mfn9SCTI5DfN7nl9Izd/FyW6bwaZ/MYYyCNvRi29GQki+Q27tr80htp+3iY/bwaRfGsbV/XNbSe6b+RRJjmI5Oa18K4pm1cwus+92tyvsTA2+TMXRPLL1KtfJOg+l/nc3Nyt89Hzt/DfQJb521Y/bm53St3Hkczc+ejaHLMNGLnM6vjWZdbWRSHvaIu5OeHIO25OPHLm5gQkt9yckOSWm3sgIjl1c6+8KyK5LOO2/t77wGm1OJBFTA5lEYXYBfpB5LMgeSgeA2z9JV/k9OAuLnV9nlNumbddXFzSeMv5ecQOf7AWXfuAfUCQqXYaSnY5B9kWfCRHSV4fPgyHP1ryamWvDdgm0ekVznRpQWGH7+1H9++xD8oCb7pyGspCsr0HJLviJ7kCTXGuPiJDGu98aDYG2aYW+ZnT0KU8O/zimejZF9mHBDDL2muiNwslu+QrOeB09DuXXdfr/ZxO8hTk9/LsOCVnHwCn0mvwEItDyY6dfH4pdIVDP7bkq49d5Be3uxetfpHP+k1uqEQglwF/zZOvPn58ctVJ7rpeDyp5HbV0vVCHuFpoMPKFCx+f9JDLsqetB7C215AhSZlUFeDSByJfPYG5efItN3oAy5ySSyUCWcGl38JH9ZLe0m3yZsvoS776yccU/OQnq0yfzlvdzxVX55b9bBXQ52Cv9oQdpuTswxOwV/scSvazOJTsfC/yImqqag2pEkI1A+mUPIMafcu8euEkoBeofv+HcPiLFzqCDJmpR52jr34Z/fLVAW0PTrf75csWeUY16oiVbAVlJERaPSph8gyq9K3tf7QLHD4tRWcfhsjhkZG3Wq10jbxVm81y3UWOX/pKWX3MCv2CQ+eYcFv/wn771dcXAH19DlLH9DVc218b0NaV7FeQ6YVzL9u62KntmSSGzeRL9XqLkFcZeT3Rv/PHHm718Z8oebedYw8XsWS7OfI2FAfb+ZNTzNahUAps52nIdPEJlGwsDtn29HAN3MSt2t4hl6rpvn069e2rFN3r2y11piWD2qtRN26Tq05y/JP09+30TKsXepHLbDQXQPKGhabl8KCmrSiFNDKsdl63urpSv06djV5x39aDnI3mAtifj6TuFUsX3EMum6Stm8eX3CEPue3mglfbx09uubmnOfHK3Iq+PHoGmE5zmc9ymplf4TpT4uFfwTnibFOLQMd7Kc+OU3Jmm7gE9edJKAvaIP35SGprMV65vWyc0yOM/owz1drLvGk8m2bHvzkb3f+G2RaAZOPLUBa05Apgm827yNWGKhnFSrFYLMNwzWIf8vTAmfn0Ia7wT7nM7OWAn05D7PjtM9Ezt5ktGvhnjq8kwWSd5EarpUoqahWLNQSjl1GtN/ngFbB05xEbyDptF+ahyopYXd05H13bYW0ADdi0cLLZGGTrijSoqEheyKVoow2j59N9yIdwOsvbjrU0zOlMLrpEoVVarGV6RVpBSsEa0jZxJSCH8wlfyLVlflpykuR0iG6VeZFU9wp+0RJSvUOOfxPU8oc8YnLokyQvUXK9UmkQcIOWPqqWlYpUxSP3Rhp/SaZnfCGno7lrznn4AJA3GjUlQ8jrVkVo4esWhKzD/pF7pyUDQE49nFLukmuo1cpoLQrtIzkNMjvc3OTJLQ/X7JJLBXp9npP8Jne7uWCQZ2w3b9Dv2jH8kk74Tu5GnyA5GchIht4k78vkfVnX6axjlfwY1TqtC71HcYcgp9EX5uYm3Z/3V9Kv/pzhONzcRMn7DcupcorP5Jabuzhhcmv80k99pyAPSU7a+rVJk4+mQ5J3gszikVtBZlNIcsvNiUguyzT6IiQ5HdKsiEhO3dxHU0s+xOI8fhlDBLf1V94HbBGzoLNRbMnD4Hdhh8Z/F7aysMLrNEqBCzJ5WzI39967wJpQZvr6mejZ1+33C2CyhQSQhQVwqWnKzzvvldEW4bZWH+JSf8DZJpjBnbPRs3fYB2B58eJitgBlAV5efHrMMZZZPsZCWmkWXHj94V08mjO9tvlZu5k6YywzkFOJgE5lJgYuKZ9AdKm300k+4Kclj1NcrQ/5KSvIPAB50OJqI5Pz05KilHmku5ZGOHJ6s5fTzQlS20kWPdEXccqc3eInYJnLbjcnUpm7oy9ClblsXa+bApa5082JVuZddNHKXO5EX4Qr846bE7DM7eiLgGVuR1+ELHMr+pIQkZy6uY/YrftBru3QdOgKuCnloHdhz10Lh9/7zjo8wF3YKXCiNwtlwU9yBArciLQA2/KGG4W74fCjb63D+9H9frZkL1RQ4Barvu562mO+HVx+3GPXU870xHcPcVuH5tuh1Z/wrqcHr/4clXyUGIvcM4r8ZzqaMwMdYxkPOSLRl5feNkUkJ6O58LopILm8tXkVo4cEJMdjGox+Y01EctncDYe/F5Jc3sQj2e9/EJFc3rwZDv/IJuKFIje3cIVfZ/OSIpHLcz8Q9GDu6zxm8rXoXxi6YOS4P79pV3jxyG9dsdDFI5/btNycgOSySQaypojkdCC7LiS5vEXc3LciktOB7HNgS9FAkcNL1GY1cDq0x66nHLlJ3NwbPDq86+mRrHvlb4HG5MBpZ+FtAHqUOX8Xthy5CqL3ugsbyoKf5D3mXvOAekySJiDb7mHH3OtfMfrzjQGTTYPJBny+veeup3+7Qju3YMy3jyPG0jOKvLF5pXvlxnScokt9Vg5s3uTQRSCncbWrnYtWgchpLPVXXnQRyO1Y6k03ugjkdvzc4+YEIjfdbk4E8s7Kga2rDnShyK2LVlMccuc6me6MrGjkXTcnArlrhVDHzYlA7l4VxqIvIpB7VoXZbk4Ecu9KQJO6ORHIuZWAW8TNwQ95Ol7k/OpP4uH//qGI5DTIDMzNHRE5Wbo3a79Y/7q7mANbM7rtZ1KLwBRmyN719IS966m1W+pMgkuWRl8wuicLszMD7WI+kto97j8/xWs5BT4EKguY9rz/nDd98A+Mzj/fKrcMJevr/ecLgJZQCpCyB9nmk5AtYofpngPsA5Rs8pu74fDzx95k9xQw2THPtw+z7S647pXsehryzrdHeqx71f+5TTo3b9PSpnTd61B7i+zsctOSxymu1oc8wk9LCkIecl2vi0VuBZkd6OKQe6clBSL3TEsKRC67oy9ikTujL2KRO6MvopF33Zxo5F03Jxp5N/oiHjlzcwKS225OSHLq5kwRya3oy1MRyamb++lnKNnjTk4vWt8ojZt81IdAjeUZPOZNij7W2ahCfBlQO5bjlVwCLON7KcA0hthx+twlZougZFN7QBZu38XoP/PJ+vqsLUC5vSyghRRkqyxDtml2mD5ri31IQ6bLUBae/Ruj//TUa7s35uerzQ7zEKgez1djNfWwz1d7dnsXmJGd1ujScHuLmNy05PTG1YbcVcXc9aJPLfmwO+lseVdGC0PunZacXvKh9xBy3cksFLksu93c1JIfZscsV/RFKHIr+sJu3Z9W8sPtFeZwc1NLfrj94ei05I2LU01+6P3hWFufWvJD7wlIpyWnmXyEPQGt6MvUko+wD6Tl5kQkt9ycOa3ko+2ASdr6v4QkJ27u+ZSSj7rfK67wv/GTfNC7sEOj34U9zOOtsrzlzraf6KgAqK2cBpQHbdEeZNsxvbcf3b/XsYVM9+Bk84ApmZb0DV0ds4y16JrhX2q7vlb48er+f/7rZ3JXA49eLjeJ1ExTkpqqjwn76+bGIJSsEzWbVSlz8FN8h9Av2+HLPibnvxyP3/aXXPrlf36m5r8YeSNhkRupRJ/nUh8noZZBJNURJTdQVSqhSWfqSISUlqbFqowcafi7RHpSuVHLfR6K7bNYbbfJ08lio4hSo6ZaLjawCEX5wKe+O9XwM/x8gLzkqUqx2DzgceUHq4QqlUpMr0tStd+jzTkVJ0eOYvi9rvf9LwOoSlyFkcCvxlBjhCMlb1l/bXIJlSR9dA9XRSzxGi7zJlKUHPmsogJCSfxGUxRyMhUVS+12iVjiLzJHS67Vrb+NnKTm8DjOyOVyo6fKyDX8i2LyilW3VFTDLVmRjBamL2N0FSkZ3J3UcDWz/s/4yDPU35SLxaKzEpKc9VOxOex53OT0LS7ZFPGcmoL5yNlxbVCtgm90/s/YyDOJKn6po1qxlKt3PU/ugOrdQMOiu8nVarVKyHOkoscUqUL56k7yar2aGyc5PWWT/sYlh8/FxdBfeHgznBh5jvIlUCPjJC9y5CWUy+jjJmeVi5wINzoyVNUU9ptkqKvBOSKlXMbvFermD0neQjZfw6rtOTJCAslTifHW9gyquK5LyLghnzM65BVUllC7WUOo1sToZZQ2JEU3qA8e7kwllMmoOqlKhE+pZ1Q8SsaDw5xaRQV6YtzmVJyXhuX3dEVVdZyFIyK3Sh/V3eRVkkGSd0ze7PyfA3ygV5USFvnNpCZ+zeilUrVEfEVJV0lFkBp6SccnVHU8ZjL0JjmATapSWfdziqArjhx3J6RPcZHjWpnIj0reQzWrMzt6uSgaMePIyZtaayLgNoDVlvCrTV63uljq4cZMLqnG0V2LOWUBNPOorDZQwiAOhoBLMermM01kkycT1PWXLQdf8X225uil5qr0J2/ouk4vx8q6TvqrGhk513TsdVRJx4x1/GsUdeyYmBNqJEe+epuwKofsNFDd54wcuQ7bXZImMOUabp6AKa/5npHB9X8Du2AJLcMtwQAAAABJRU5ErkJggg==

          //odi od 0,0 do 7,7 i popolnuvaj BoardModel
          val col = File.allFiles[0] //file is column, example A-File, H-File
          val row = Rank.allRanks[0] //rank is 1st to 8th rank
          val sq = Square.encode(row, col)
          val piece = board.getPiece(sq)

          //val sqModel00 = SquareModel(0, 0, "K", false, false);

          //treba da se popolni BoardModel()

          //val activeBoard = mutableStateOf(BoardModel())
          var activeBoard = BoardModel()
          //activeBoard.add(sqModel00) //ova ke imame za site 64 polinja


          //activeBoard
          RefreshableBoard()
        }
      }
    }
  }
}

@Preview(device = Devices.DEFAULT, showSystemUi = true)
@Composable
fun RefreshableBoard() {

  //  var name by remember { mutableStateOf("") }
  //
  //  var activeBoard by remember { MutableState( BoardModel()) }

  var activeBoard = BoardModel()
  Board(activeBoard, onBoardUpdate = { activeBoard = it })
}


@Composable
fun Board(board: BoardModel, onBoardUpdate: (BoardModel) -> Unit) {
  val darkSquare = Color(0xFF779556)
  val lightSquare = Color(0xFFEBECD0)

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.LightGray)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .border(BorderStroke(width = 2.dp, color = Color.Black))
        .padding(2.dp)
    ) {
      for (y in 0..7) {
        Row {
          for (x in 0..7) { //board.isLightSquare

            val squareColor = if (board.get(x, y).isLightSquare) lightSquare else darkSquare

            //should be part of board-state
            var selected by remember { mutableStateOf(false) }

            //one square item
            Box(modifier = Modifier
              .weight(1f)
              .aspectRatio(1f)
              .border(
                BorderStroke(
                  width = 2.dp, color = if (selected) Color.Red else Color.Transparent
                )
              )
              .background(squareColor)
              .clickable {
                selected = !selected //board.set(i,j - x,y) = selected
                //board.setSelectedField(x,y)
                //treba da se napraj pak trigger za valid fields preku usecase
              }) {
              Text(text = "${x},${y}") //boardModel.fromSquareToCoordinate(Square.A5)

              //check the state for the item at x,y for
              //isEmpty
              //isSelected
              //field is valid move
              //isValid move
              //and draw it on the screen

              //              if(board.getItem(x,y).isValidMove){
              //                Image(
              //                  painter = painterResource(id = R.drawable.valid_move), contentDescription = null
              //                    )
              //              }


              //take the items from the model and draw tem
              //if(white or black peace)
              //              if(board.get(x,y).isRook()){
              //                Image(
              //                  painter = painterResource(id = R.drawable.white_rook), contentDescription = null
              //                )
              //              }
            }
          }
        }
      }
    }
  }
}


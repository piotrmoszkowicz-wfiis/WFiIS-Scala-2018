import scala.swing._
import scala.io.Source
import java.io._
import java.awt.event._
import javax.swing.Timer

class Comm (val uname: String){
  
  // to trzeba zmienic tak aby:
  // komunikaty od nas dla kolegi/kolezanki trafialy do pliku
  // $HOME/comm/jego/jej-login
  // komunikaty od kolegi/kolezanki bedziemy czytac z jego kat domowego/comm/nasz-login
  // def getLocation = "/home/stud2011/"+uname+"/comm/"+sys.env("USER")
  private def getLocation = "/home/stud2017/" + uname + "/messenger_data/"+sys.env("USER")
  // to powinno byc juz ok
  private def postLocation = sys.env("HOME")+"/messenger_data/"+uname

  def getMessage = {
    Source.fromFile(getLocation).mkString("")
  }


  def postMessage(msg:String) {
    val writer = new BufferedWriter(new FileWriter(postLocation, true))
    writer.write(msg+"\n")
    writer.close
  }
  def reset() {
    val writer = new BufferedWriter(new FileWriter(postLocation, false))
    writer.write("--\n")
    writer.close
  }
}

object Main extends SimpleSwingApplication {
  val communication = new Comm("7litarowicz")

  val outputTextField = new TextField()
  outputTextField.editable_=(false)
  val inputTextField = new TextField()
  val sendButton = new Button(Action("Send") {
    communication.postMessage(inputTextField.text)
    inputTextField.text_=("")
  })
  val closeButton = new Button(Action("Close") {
    quit
  })

  def top: MainFrame = new MainFrame {
    title = "Gadu Gadu"
    contents = new BoxPanel(Orientation.Vertical) {
      contents += outputTextField
      contents += inputTextField
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += sendButton
        contents += closeButton
      }
    }
    size = new Dimension(600, 150)
  }

  val readMessagePerformer = new ActionListener() {
    def actionPerformed(evt: ActionEvent) {
      outputTextField.text_=(communication.getMessage)
    }
  }

  new Timer(100, readMessagePerformer).start()
}

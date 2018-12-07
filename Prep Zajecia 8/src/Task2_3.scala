class Server(var agents: List[NewCon] = List.empty) {
  def << (myClass: Any): Server = {
    myClass match {
      case newCon: NewCon =>
        println(newCon)
        agents = newCon :: agents
      case drop: Drop =>
        println(drop)
        agents = agents.filter(_.agent != drop.agent)
      case request: Request =>
        if (agents.exists(_.agent == request.agent)) {
          println(request.accept)
        } else {
          println(request.reject)
        }
    }
    this
  }
}

case class NewCon(agent: String) extends Server {
  override def toString: String = s" new connection from agent $agent"
}
case class Drop(agent: String) extends Server {
  override def toString: String = s" drop connection from agent $agent"
}
case class Request(agent: String, file: String) extends Server {
  def accept: String = s"serving resource$file to agent $agent"
  def reject: String = s"ERROR: Unknown agent $agent , not serving: $file"
}

object Task2_3 {
  def main(args: Array[String]): Unit = {
    val s = new Server
    s << NewCon("Agent1") << Drop("Agent1")
    s << Request( "Agent1", "file::/home/data" )
    s << NewCon("Agent1") << Request( "Agent1", "file::/home/data" )
    s << NewCon("Agent1") << Request( "Agent1", "file::/home/data" )
    s << NewCon("Agent007") << Request( "Agent1", "file::/home/data" ) << Request("Agent007", "Life")
    s << Drop("Agent007") << Drop("Agent1")
  }
}

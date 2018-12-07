abstract class ServerEvent

case class NewCon(agent: String) extends ServerEvent
case class Drop(agent: String) extends ServerEvent
case class Request(agent: String, resource: String) extends ServerEvent

class Server() {
  var agents: List[String] = List.empty
  def <<(event: ServerEvent): Server = {
    event match {
      case NewCon(agent) =>
        println(s" new connection from agent $agent")
        agents = agent :: agents
      case Drop(agent) =>
        println(s" drop connection from agent $agent")
        agents = agents.filter(_ != agent)
      case Request(agent, resource) if agents.contains(agent) =>
        println(s"serving resource$resource to agent $agent")
      case Request(agent, resource) =>
        println(s"ERROR: Unknown agent $agent , not serving: $resource")
    }
    this
  }
}

object Task2_3_nice {
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

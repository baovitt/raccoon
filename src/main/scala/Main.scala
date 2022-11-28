package raccoon:

  import raccoon.libos.*

  import scala.scalanative.unsafe.*
  import zio.*

  @extern
  @link("add")
  object Add:

    def add(a: CInt, b: CInt): CInt = extern
    
  end Add
  

  object Main extends ZIOAppDefault:

    override def run = ZIO.succeed(Add.add(1, 5))

  end Main

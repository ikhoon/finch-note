import io.finch._
import io.finch.circe._
import io.circe.generic.auto._
import com.twitter.finagle.http.{Method, Request}
import shapeless._

val e = get[HNil](/)

val remoteAddr = root.map(_.remoteAddress)
remoteAddr(Input.get("/")).value

e(Input.post("/")).isDefined

e(Input.get("/")).isDefined

case class Locale(language: String, country: String)
post("time" :: jsonBody[Locale])

val i: Endpoint[Int] = int
val s: Endpoint[String] = string
val both: Endpoint[Int :: String :: HNil] = i :: s

val either: Endpoint[Int :+: String :+: CNil] = i :+: s

val sum = both { (a: Int, b: String) =>
  Ok(a + b.toInt)
}

case class Foo(i: Int, s: String)

val foo: Endpoint[Foo] = both.as[Foo]

val e1 = param("i").as[Int] :: param("s")
e1.as[Foo]

// validation
case class User(name: String, age: Int)
val user: Endpoint[User] = (
  param("name") ::
  param("age").as[Int].shouldNot("be less then 18") { _ < 18}
).as[User]

val bePositive = ValidationRule[Int]("be positive") { _ > 0 }
def beLessThen(value: Int) = ValidationRule[Int](s"be less then $value") { _ < value}

val child: Endpoint[User] = (
  param("name") ::
  param("age").as[Int].should(bePositive and beLessThen(18))
).as[User]



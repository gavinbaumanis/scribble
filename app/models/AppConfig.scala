package models

import play.api.libs.json._

case class AppConfig(blogTitle: String, blogTagLine: String, blogTitleImage: String, blogUrl: String, accurateAt: java.util.Date, modifiedBy: NormalUser)

object AppConfig {
  implicit val NormalUserFormat = Json.format[NormalUser]
  
  implicit val AppConfigFormat = Json.format[AppConfig]
  
}
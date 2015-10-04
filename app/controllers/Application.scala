package controllers

import play.api._
import play.api.mvc._
import java.util.Date._
import play.api.i18n._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.libs.json.Json

import java.util.Date
import scala.concurrent.{ ExecutionContext, Future }
import javax.inject._


class Application @Inject() (val messagesApi: MessagesApi)
  (implicit ec: ExecutionContext) extends Controller with I18nSupport{
   
	// Default / Home Page
	def index = Action {
		Ok(views.html.index())
	}//End index

  
	// System Administration menu
	def sysconfig = Action {
		Ok(views.html.sysconfig())
	}//End sysconfig

  
  //Application Configuration Actions
   /**
   * The mapping for the App Config form.
   */
  val AppConfigForm: Form[CreateAppConfigForm] = Form {
    mapping(
      "blogTitle" -> nonEmptyText,
      "blogTagLine" -> nonEmptyText,
      "blogTitleImage" -> nonEmptyText,
      "blogUrl" -> nonEmptyText,
      "accurateAt" -> date,
      "modifiedBy" -> mapping("firstName" -> text,
                              "lastName" -> text
        )(NormalUserForm.apply)(NormalUserForm.unapply)
    )(CreateAppConfigForm.apply)(CreateAppConfigForm.unapply)
  }//End AppConfigForm
 
 
	// Configure THIS installation of the ScalaBlog application
	def appconfig = Action {
		Ok(views.html.appconfig(AppConfigForm))
	}//End appconfig

	
  //SAVE the contents of the AppConfig Form.
	def appconfigsubmit = Action {
		//TODO: verify the contents of the form are valid
		//TODO: save the form

		//Return the SYS config Menu
		Ok(views.html.sysconfig())
	}//End appconfigsubmit
}//End Application controller class


/**
 * Case classes 
 * 
 * The following case classes are used "here" within the controller only.
 * It is quite often the case that the model representation and that which is needed within a view are different.
 * So we can use the controller as an appropriate place to hold this interfacing code.
 * 
 * You can also use "nested" values.
 * In THIS controller we embed the Normal User case class into the CreateAppConfigForm case class.
 */

case class NormalUserForm(firstName: String, lastName: String)

case class CreateAppConfigForm(blogTitle: String, blogTagLine: String, blogTitleImage: String, blogUrl: String, accurateAt: java.util.Date, modifiedBy: NormalUserForm)
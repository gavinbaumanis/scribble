package models

trait User {
	def id: Int
	def modifiedBy: User
}

case class SystemUser(id: Int,
		username: String = "ScalaBlog System",
		password: String = "",
		avatar: String = "",
		emailAddress: String = "",
		twitter: String = "",
		gitHub: String = "",
		websiteURL: String = "",

		firstName: String = "ScalaBlog",
		lastName: String = "System",
		displayName: String = "ScalaBlog System",
		address1: String = "",
		address2: String = "",
		suburb: String = "Melbourne",
		state: String = "Victoria",
		postCode: String = "3000",
		country: String = "Australia",

		homePhone: String = "",
		mobilePhone: String = "",
		workPhone: String = "",

		active: Boolean = true,

		modifiedDateTime: java.util.Date = new java.util.Date()) extends User { //Mixin the User trait
    def modifiedBy = this
}

case class NormalUser(id: Int,
	username: String,
	password: String,
	avatar: String,
	emailAddress: String,
	twitter: String,
	gitHub: String,
	websiteURL: String,

	firstName: String,
	lastName: String,
	displayName: String,
	address1: String,
	address2: String,
	suburb: String,
	state: String,
	postCode: String,
	country: String,

	homePhone: String,
	mobilePhone: String,
	workPhone: String,

	active: Boolean = true,

	modifiedBy: User,
	modifiedDateTime: java.util.Date = new java.util.Date()) extends User // Mixin the User trait

//Singleton / Companion Object for the System Account
object SystemUser {

}

//Singleton / Companion Object for NormaL Users - real people!
object NormalUser {

}

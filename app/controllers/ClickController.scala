package controllers

import javax.inject._

import play.api.mvc._
import services.Counter

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class creates an
 * `Action` that shows an incrementing count to users. The [[Counter]]
 * object is injected by the Guice dependency injection system.
 */
@Singleton
class ClickController @Inject()(cc: ControllerComponents, counter: Counter)
                               (implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {

  def click = Action {
    val count = counter.nextCount().toString
    Ok(views.html.clicks("How many clicks?", count))
  }

}

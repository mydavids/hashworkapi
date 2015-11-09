package controllers.common.education

import domain.common.education.Evaluation
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.common.education.EvaluationService
import scala.concurrent.ExecutionContext.Implicits.global
/**
 * Created by hashcode on 2015/11/09.
 */
class EvaluationController extends Controller{

  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      val entity = Json.fromJson[Evaluation](input).get
      val results = EvaluationService.saveOrUpdate(entity)
      results.map(result =>
        Ok(Json.toJson(entity)))
  }

}

package services.company

import com.datastax.driver.core.ResultSet
import domain.company.Company
import repository.company.CompanyRepository
import services.Service

import scala.concurrent.Future

/**
 * Created by hashcode on 2015/11/08.
 */
object CompanyService extends Service {

  def saveOrUpdate(entity: Company): Future[ResultSet] = {
    CompanyRepository.save(entity)
  }

  def getById(id: String): Future[Option[Company]] = {
    CompanyRepository.findById(id)
  }

  def isAvailable(id: String): Future[Boolean] = {
    CompanyRepository.findById(id) map (company => {
      company match {
        case Some => true
        case None => false
      }
    })
  }

}

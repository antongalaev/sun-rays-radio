package services.lastfm

import java.util

import de.umass.lastfm.cache.DefaultExpirationPolicy

class CacheExpirationPolicy extends DefaultExpirationPolicy {
  override def getExpirationTime(method: String, params: util.Map[String, String]): Long = {
    DefaultExpirationPolicy.ONE_DAY
  }
}

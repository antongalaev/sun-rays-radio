package services.lastfm

import java.util.logging.Level

import com.typesafe.config.ConfigFactory
import de.umass.lastfm._
import javax.inject.Singleton

import scala.jdk.CollectionConverters._

@Singleton
class LastFm {
  val conf = ConfigFactory.load()
  val userAgent = conf.getString("fm.agent")
  val user = conf.getString("fm.user")
  val key = conf.getString("fm.key")
  val top = conf.getInt("fm.top.limit")

  Caller.getInstance.getLogger.setLevel(Level.ALL)
  Caller.getInstance.setUserAgent(userAgent)
  Caller.getInstance.getCache.setExpirationPolicy(new CacheExpirationPolicy)

  def getTopArtists: Iterable[Artist] = {
    val chart = User.getTopArtists(user, Period.ONE_MONTH, key)
    printf("Got %d top artists\n", chart.size)
    chart.asScala.take(top)
  }

  def getTopAlbums: Iterable[Album] = {
    val chart = User.getTopAlbums(user, Period.ONE_MONTH, key)
    printf("Got %d top albums\n", chart.size)
    chart.asScala.take(top)
  }

  def getTopTracks: Iterable[Track] = {
    val chart = User.getTopTracks(user, Period.ONE_MONTH, key)
    printf("Got %d top tracks\n", chart.size)
    chart.asScala.take(top)
  }
}

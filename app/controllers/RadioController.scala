package controllers

import java.nio.file.Files

import javax.inject.{Inject, Singleton}
import play.api.http.HttpEntity
import play.api.mvc.{AbstractController, ControllerComponents, ResponseHeader, Result}
import services.lastfm.LastFm

@Singleton
class RadioController @Inject()(cc: ControllerComponents, lastFm: LastFm)(implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {

  def mix = Action {
    Ok(views.html.mix("A Mix for Friends"))
  }

  def onAir = Action {
    Ok(views.html.onair("On Air"))
  }

  def artists = Action {
    val artists = lastFm.getTopArtists
    Ok(views.html.artists("Top Artists Now", artists))
  }

  def albums = Action {
    val albums = lastFm.getTopAlbums
    Ok(views.html.albums("Top Albums Now", albums))
  }

  def tracks = Action {
    val tracks = lastFm.getTopTracks
    Ok(views.html.tracks("Top Tracks Now", tracks))
  }

}

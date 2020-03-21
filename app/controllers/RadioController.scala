package controllers

import java.nio.file.Files

import akka.stream.scaladsl.{FileIO, Source}
import akka.util.ByteString
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

  def stream(id: Int) = Action {
    val file                          = new java.io.File("/home/ubuntu/mixes/%d.mp3".format(id))
    val path: java.nio.file.Path      = file.toPath
    val source: Source[ByteString, _] = FileIO.fromPath(path)
    val contentLength = Some(Files.size(file.toPath))

    Result(
      header = ResponseHeader(200, Map.empty),
      body = HttpEntity.Streamed(source, contentLength, Some("audio/mpeg"))
    )
  }

  def firstRays = Action {
    Ok(views.html.firstrays("First Rays"))
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

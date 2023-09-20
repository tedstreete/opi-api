// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: backend_aio.proto

package opi_api.storage.v1;

public interface CreateAioVolumeRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:opi_api.storage.v1.CreateAioVolumeRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The Aio Volume to be created.
   * </pre>
   *
   * <code>.opi_api.storage.v1.AioVolume aio_volume = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return Whether the aioVolume field is set.
   */
  boolean hasAioVolume();
  /**
   * <pre>
   * The Aio Volume to be created.
   * </pre>
   *
   * <code>.opi_api.storage.v1.AioVolume aio_volume = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The aioVolume.
   */
  opi_api.storage.v1.AioVolume getAioVolume();
  /**
   * <pre>
   * The Aio Volume to be created.
   * </pre>
   *
   * <code>.opi_api.storage.v1.AioVolume aio_volume = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  opi_api.storage.v1.AioVolumeOrBuilder getAioVolumeOrBuilder();

  /**
   * <pre>
   * An optional ID to assign to the Aio Volume.
   * If this is not provided the system will auto-generate it.
   * </pre>
   *
   * <code>string aio_volume_id = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return The aioVolumeId.
   */
  java.lang.String getAioVolumeId();
  /**
   * <pre>
   * An optional ID to assign to the Aio Volume.
   * If this is not provided the system will auto-generate it.
   * </pre>
   *
   * <code>string aio_volume_id = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return The bytes for aioVolumeId.
   */
  com.google.protobuf.ByteString
      getAioVolumeIdBytes();
}
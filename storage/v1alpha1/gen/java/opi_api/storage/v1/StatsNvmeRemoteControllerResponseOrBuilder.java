// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: backend_nvme.proto

package opi_api.storage.v1;

public interface StatsNvmeRemoteControllerResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:opi_api.storage.v1.StatsNvmeRemoteControllerResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Controller statistics
   * </pre>
   *
   * <code>.opi_api.storage.v1.VolumeStats stats = 1;</code>
   * @return Whether the stats field is set.
   */
  boolean hasStats();
  /**
   * <pre>
   * Controller statistics
   * </pre>
   *
   * <code>.opi_api.storage.v1.VolumeStats stats = 1;</code>
   * @return The stats.
   */
  opi_api.storage.v1.VolumeStats getStats();
  /**
   * <pre>
   * Controller statistics
   * </pre>
   *
   * <code>.opi_api.storage.v1.VolumeStats stats = 1;</code>
   */
  opi_api.storage.v1.VolumeStatsOrBuilder getStatsOrBuilder();
}

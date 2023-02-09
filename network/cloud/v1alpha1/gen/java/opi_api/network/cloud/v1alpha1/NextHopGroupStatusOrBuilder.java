// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nexthop.proto

package opi_api.network.cloud.v1alpha1;

public interface NextHopGroupStatusOrBuilder extends
    // @@protoc_insertion_point(interface_extends:opi_api.network.cloud.v1alpha1.NextHopGroupStatus)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * nexthop group member status
   * </pre>
   *
   * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
   */
  java.util.List<opi_api.network.cloud.v1alpha1.NextHopStatus> 
      getMembersList();
  /**
   * <pre>
   * nexthop group member status
   * </pre>
   *
   * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
   */
  opi_api.network.cloud.v1alpha1.NextHopStatus getMembers(int index);
  /**
   * <pre>
   * nexthop group member status
   * </pre>
   *
   * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
   */
  int getMembersCount();
  /**
   * <pre>
   * nexthop group member status
   * </pre>
   *
   * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
   */
  java.util.List<? extends opi_api.network.cloud.v1alpha1.NextHopStatusOrBuilder> 
      getMembersOrBuilderList();
  /**
   * <pre>
   * nexthop group member status
   * </pre>
   *
   * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
   */
  opi_api.network.cloud.v1alpha1.NextHopStatusOrBuilder getMembersOrBuilder(
      int index);

  /**
   * <pre>
   * nexthop group hw id
   * </pre>
   *
   * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
   * @return Whether the hwHandle field is set.
   */
  boolean hasHwHandle();
  /**
   * <pre>
   * nexthop group hw id
   * </pre>
   *
   * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
   * @return The hwHandle.
   */
  opi_api.network.opinetcommon.v1alpha1.HwHandle getHwHandle();
  /**
   * <pre>
   * nexthop group hw id
   * </pre>
   *
   * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
   */
  opi_api.network.opinetcommon.v1alpha1.HwHandleOrBuilder getHwHandleOrBuilder();
}
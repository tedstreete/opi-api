// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: networktypes.proto

package opi_api.network.opinetcommon.v1alpha1;

public interface IPAddressOrBuilder extends
    // @@protoc_insertion_point(interface_extends:opi_api.network.opinetcommon.v1alpha1.IPAddress)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * IP Address family
   * </pre>
   *
   * <code>.opi_api.network.opinetcommon.v1alpha1.IpAf af = 1;</code>
   * @return The enum numeric value on the wire for af.
   */
  int getAfValue();
  /**
   * <pre>
   * IP Address family
   * </pre>
   *
   * <code>.opi_api.network.opinetcommon.v1alpha1.IpAf af = 1;</code>
   * @return The af.
   */
  opi_api.network.opinetcommon.v1alpha1.IpAf getAf();

  /**
   * <pre>
   * IPv4 address
   * (-- api-linter: core::0141::forbidden-types=disabled
   *     aip.dev/not-precedent: must use fixed32 --)
   * </pre>
   *
   * <code>fixed32 v4_addr = 2;</code>
   * @return Whether the v4Addr field is set.
   */
  boolean hasV4Addr();
  /**
   * <pre>
   * IPv4 address
   * (-- api-linter: core::0141::forbidden-types=disabled
   *     aip.dev/not-precedent: must use fixed32 --)
   * </pre>
   *
   * <code>fixed32 v4_addr = 2;</code>
   * @return The v4Addr.
   */
  int getV4Addr();

  /**
   * <pre>
   * IPv6 address
   * </pre>
   *
   * <code>bytes v6_addr = 3;</code>
   * @return Whether the v6Addr field is set.
   */
  boolean hasV6Addr();
  /**
   * <pre>
   * IPv6 address
   * </pre>
   *
   * <code>bytes v6_addr = 3;</code>
   * @return The v6Addr.
   */
  com.google.protobuf.ByteString getV6Addr();

  public opi_api.network.opinetcommon.v1alpha1.IPAddress.V4OrV6Case getV4OrV6Case();
}
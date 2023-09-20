// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: backend_nvme_tcp.proto

package opi_api.storage.v1;

public interface NvmePathOrBuilder extends
    // @@protoc_insertion_point(interface_extends:opi_api.storage.v1.NvmePath)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * name is an opaque object handle that is not user settable.
   * name will be returned with created object
   * user can only set {resource}_id on the Create request object
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = OUTPUT_ONLY, (.google.api.field_behavior) = IMMUTABLE, (.google.api.resource_reference) = { ... }</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <pre>
   * name is an opaque object handle that is not user settable.
   * name will be returned with created object
   * user can only set {resource}_id on the Create request object
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = OUTPUT_ONLY, (.google.api.field_behavior) = IMMUTABLE, (.google.api.resource_reference) = { ... }</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string controller_name_ref = 2 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
   * @return The controllerNameRef.
   */
  java.lang.String getControllerNameRef();
  /**
   * <code>string controller_name_ref = 2 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
   * @return The bytes for controllerNameRef.
   */
  com.google.protobuf.ByteString
      getControllerNameRefBytes();

  /**
   * <code>.opi_api.storage.v1.NvmeTransportType trtype = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The enum numeric value on the wire for trtype.
   */
  int getTrtypeValue();
  /**
   * <code>.opi_api.storage.v1.NvmeTransportType trtype = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The trtype.
   */
  opi_api.storage.v1.NvmeTransportType getTrtype();

  /**
   * <pre>
   * Destination address (e.g. IP address, BDF for local PCIe)
   * </pre>
   *
   * <code>string traddr = 4 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The traddr.
   */
  java.lang.String getTraddr();
  /**
   * <pre>
   * Destination address (e.g. IP address, BDF for local PCIe)
   * </pre>
   *
   * <code>string traddr = 4 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The bytes for traddr.
   */
  com.google.protobuf.ByteString
      getTraddrBytes();

  /**
   * <pre>
   * Not applicable for local PCIe. Required for Nvme over fabrics transport types
   * </pre>
   *
   * <code>.opi_api.storage.v1.FabricsPath fabrics = 5 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return Whether the fabrics field is set.
   */
  boolean hasFabrics();
  /**
   * <pre>
   * Not applicable for local PCIe. Required for Nvme over fabrics transport types
   * </pre>
   *
   * <code>.opi_api.storage.v1.FabricsPath fabrics = 5 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return The fabrics.
   */
  opi_api.storage.v1.FabricsPath getFabrics();
  /**
   * <pre>
   * Not applicable for local PCIe. Required for Nvme over fabrics transport types
   * </pre>
   *
   * <code>.opi_api.storage.v1.FabricsPath fabrics = 5 [(.google.api.field_behavior) = OPTIONAL];</code>
   */
  opi_api.storage.v1.FabricsPathOrBuilder getFabricsOrBuilder();
}
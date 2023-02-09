// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nexthop.proto

package opi_api.network.cloud.v1alpha1;

/**
 * <pre>
 * operational status of nexthop group, if any
 * </pre>
 *
 * Protobuf type {@code opi_api.network.cloud.v1alpha1.NextHopGroupStatus}
 */
public final class NextHopGroupStatus extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:opi_api.network.cloud.v1alpha1.NextHopGroupStatus)
    NextHopGroupStatusOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NextHopGroupStatus.newBuilder() to construct.
  private NextHopGroupStatus(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NextHopGroupStatus() {
    members_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new NextHopGroupStatus();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NextHopGroupStatus(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              members_ = new java.util.ArrayList<opi_api.network.cloud.v1alpha1.NextHopStatus>();
              mutable_bitField0_ |= 0x00000001;
            }
            members_.add(
                input.readMessage(opi_api.network.cloud.v1alpha1.NextHopStatus.parser(), extensionRegistry));
            break;
          }
          case 18: {
            opi_api.network.opinetcommon.v1alpha1.HwHandle.Builder subBuilder = null;
            if (hwHandle_ != null) {
              subBuilder = hwHandle_.toBuilder();
            }
            hwHandle_ = input.readMessage(opi_api.network.opinetcommon.v1alpha1.HwHandle.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(hwHandle_);
              hwHandle_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        members_ = java.util.Collections.unmodifiableList(members_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return opi_api.network.cloud.v1alpha1.NextHopProto.internal_static_opi_api_network_cloud_v1alpha1_NextHopGroupStatus_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return opi_api.network.cloud.v1alpha1.NextHopProto.internal_static_opi_api_network_cloud_v1alpha1_NextHopGroupStatus_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            opi_api.network.cloud.v1alpha1.NextHopGroupStatus.class, opi_api.network.cloud.v1alpha1.NextHopGroupStatus.Builder.class);
  }

  public static final int MEMBERS_FIELD_NUMBER = 1;
  private java.util.List<opi_api.network.cloud.v1alpha1.NextHopStatus> members_;
  /**
   * <pre>
   * nexthop group member status
   * </pre>
   *
   * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
   */
  @java.lang.Override
  public java.util.List<opi_api.network.cloud.v1alpha1.NextHopStatus> getMembersList() {
    return members_;
  }
  /**
   * <pre>
   * nexthop group member status
   * </pre>
   *
   * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends opi_api.network.cloud.v1alpha1.NextHopStatusOrBuilder> 
      getMembersOrBuilderList() {
    return members_;
  }
  /**
   * <pre>
   * nexthop group member status
   * </pre>
   *
   * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
   */
  @java.lang.Override
  public int getMembersCount() {
    return members_.size();
  }
  /**
   * <pre>
   * nexthop group member status
   * </pre>
   *
   * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
   */
  @java.lang.Override
  public opi_api.network.cloud.v1alpha1.NextHopStatus getMembers(int index) {
    return members_.get(index);
  }
  /**
   * <pre>
   * nexthop group member status
   * </pre>
   *
   * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
   */
  @java.lang.Override
  public opi_api.network.cloud.v1alpha1.NextHopStatusOrBuilder getMembersOrBuilder(
      int index) {
    return members_.get(index);
  }

  public static final int HW_HANDLE_FIELD_NUMBER = 2;
  private opi_api.network.opinetcommon.v1alpha1.HwHandle hwHandle_;
  /**
   * <pre>
   * nexthop group hw id
   * </pre>
   *
   * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
   * @return Whether the hwHandle field is set.
   */
  @java.lang.Override
  public boolean hasHwHandle() {
    return hwHandle_ != null;
  }
  /**
   * <pre>
   * nexthop group hw id
   * </pre>
   *
   * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
   * @return The hwHandle.
   */
  @java.lang.Override
  public opi_api.network.opinetcommon.v1alpha1.HwHandle getHwHandle() {
    return hwHandle_ == null ? opi_api.network.opinetcommon.v1alpha1.HwHandle.getDefaultInstance() : hwHandle_;
  }
  /**
   * <pre>
   * nexthop group hw id
   * </pre>
   *
   * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
   */
  @java.lang.Override
  public opi_api.network.opinetcommon.v1alpha1.HwHandleOrBuilder getHwHandleOrBuilder() {
    return getHwHandle();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < members_.size(); i++) {
      output.writeMessage(1, members_.get(i));
    }
    if (hwHandle_ != null) {
      output.writeMessage(2, getHwHandle());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < members_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, members_.get(i));
    }
    if (hwHandle_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getHwHandle());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof opi_api.network.cloud.v1alpha1.NextHopGroupStatus)) {
      return super.equals(obj);
    }
    opi_api.network.cloud.v1alpha1.NextHopGroupStatus other = (opi_api.network.cloud.v1alpha1.NextHopGroupStatus) obj;

    if (!getMembersList()
        .equals(other.getMembersList())) return false;
    if (hasHwHandle() != other.hasHwHandle()) return false;
    if (hasHwHandle()) {
      if (!getHwHandle()
          .equals(other.getHwHandle())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getMembersCount() > 0) {
      hash = (37 * hash) + MEMBERS_FIELD_NUMBER;
      hash = (53 * hash) + getMembersList().hashCode();
    }
    if (hasHwHandle()) {
      hash = (37 * hash) + HW_HANDLE_FIELD_NUMBER;
      hash = (53 * hash) + getHwHandle().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static opi_api.network.cloud.v1alpha1.NextHopGroupStatus parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static opi_api.network.cloud.v1alpha1.NextHopGroupStatus parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static opi_api.network.cloud.v1alpha1.NextHopGroupStatus parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static opi_api.network.cloud.v1alpha1.NextHopGroupStatus parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static opi_api.network.cloud.v1alpha1.NextHopGroupStatus parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static opi_api.network.cloud.v1alpha1.NextHopGroupStatus parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static opi_api.network.cloud.v1alpha1.NextHopGroupStatus parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static opi_api.network.cloud.v1alpha1.NextHopGroupStatus parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static opi_api.network.cloud.v1alpha1.NextHopGroupStatus parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static opi_api.network.cloud.v1alpha1.NextHopGroupStatus parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static opi_api.network.cloud.v1alpha1.NextHopGroupStatus parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static opi_api.network.cloud.v1alpha1.NextHopGroupStatus parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(opi_api.network.cloud.v1alpha1.NextHopGroupStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * operational status of nexthop group, if any
   * </pre>
   *
   * Protobuf type {@code opi_api.network.cloud.v1alpha1.NextHopGroupStatus}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:opi_api.network.cloud.v1alpha1.NextHopGroupStatus)
      opi_api.network.cloud.v1alpha1.NextHopGroupStatusOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return opi_api.network.cloud.v1alpha1.NextHopProto.internal_static_opi_api_network_cloud_v1alpha1_NextHopGroupStatus_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return opi_api.network.cloud.v1alpha1.NextHopProto.internal_static_opi_api_network_cloud_v1alpha1_NextHopGroupStatus_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              opi_api.network.cloud.v1alpha1.NextHopGroupStatus.class, opi_api.network.cloud.v1alpha1.NextHopGroupStatus.Builder.class);
    }

    // Construct using opi_api.network.cloud.v1alpha1.NextHopGroupStatus.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getMembersFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (membersBuilder_ == null) {
        members_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        membersBuilder_.clear();
      }
      if (hwHandleBuilder_ == null) {
        hwHandle_ = null;
      } else {
        hwHandle_ = null;
        hwHandleBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return opi_api.network.cloud.v1alpha1.NextHopProto.internal_static_opi_api_network_cloud_v1alpha1_NextHopGroupStatus_descriptor;
    }

    @java.lang.Override
    public opi_api.network.cloud.v1alpha1.NextHopGroupStatus getDefaultInstanceForType() {
      return opi_api.network.cloud.v1alpha1.NextHopGroupStatus.getDefaultInstance();
    }

    @java.lang.Override
    public opi_api.network.cloud.v1alpha1.NextHopGroupStatus build() {
      opi_api.network.cloud.v1alpha1.NextHopGroupStatus result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public opi_api.network.cloud.v1alpha1.NextHopGroupStatus buildPartial() {
      opi_api.network.cloud.v1alpha1.NextHopGroupStatus result = new opi_api.network.cloud.v1alpha1.NextHopGroupStatus(this);
      int from_bitField0_ = bitField0_;
      if (membersBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          members_ = java.util.Collections.unmodifiableList(members_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.members_ = members_;
      } else {
        result.members_ = membersBuilder_.build();
      }
      if (hwHandleBuilder_ == null) {
        result.hwHandle_ = hwHandle_;
      } else {
        result.hwHandle_ = hwHandleBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof opi_api.network.cloud.v1alpha1.NextHopGroupStatus) {
        return mergeFrom((opi_api.network.cloud.v1alpha1.NextHopGroupStatus)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(opi_api.network.cloud.v1alpha1.NextHopGroupStatus other) {
      if (other == opi_api.network.cloud.v1alpha1.NextHopGroupStatus.getDefaultInstance()) return this;
      if (membersBuilder_ == null) {
        if (!other.members_.isEmpty()) {
          if (members_.isEmpty()) {
            members_ = other.members_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureMembersIsMutable();
            members_.addAll(other.members_);
          }
          onChanged();
        }
      } else {
        if (!other.members_.isEmpty()) {
          if (membersBuilder_.isEmpty()) {
            membersBuilder_.dispose();
            membersBuilder_ = null;
            members_ = other.members_;
            bitField0_ = (bitField0_ & ~0x00000001);
            membersBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getMembersFieldBuilder() : null;
          } else {
            membersBuilder_.addAllMessages(other.members_);
          }
        }
      }
      if (other.hasHwHandle()) {
        mergeHwHandle(other.getHwHandle());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      opi_api.network.cloud.v1alpha1.NextHopGroupStatus parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (opi_api.network.cloud.v1alpha1.NextHopGroupStatus) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<opi_api.network.cloud.v1alpha1.NextHopStatus> members_ =
      java.util.Collections.emptyList();
    private void ensureMembersIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        members_ = new java.util.ArrayList<opi_api.network.cloud.v1alpha1.NextHopStatus>(members_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        opi_api.network.cloud.v1alpha1.NextHopStatus, opi_api.network.cloud.v1alpha1.NextHopStatus.Builder, opi_api.network.cloud.v1alpha1.NextHopStatusOrBuilder> membersBuilder_;

    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public java.util.List<opi_api.network.cloud.v1alpha1.NextHopStatus> getMembersList() {
      if (membersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(members_);
      } else {
        return membersBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public int getMembersCount() {
      if (membersBuilder_ == null) {
        return members_.size();
      } else {
        return membersBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public opi_api.network.cloud.v1alpha1.NextHopStatus getMembers(int index) {
      if (membersBuilder_ == null) {
        return members_.get(index);
      } else {
        return membersBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public Builder setMembers(
        int index, opi_api.network.cloud.v1alpha1.NextHopStatus value) {
      if (membersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMembersIsMutable();
        members_.set(index, value);
        onChanged();
      } else {
        membersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public Builder setMembers(
        int index, opi_api.network.cloud.v1alpha1.NextHopStatus.Builder builderForValue) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        members_.set(index, builderForValue.build());
        onChanged();
      } else {
        membersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public Builder addMembers(opi_api.network.cloud.v1alpha1.NextHopStatus value) {
      if (membersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMembersIsMutable();
        members_.add(value);
        onChanged();
      } else {
        membersBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public Builder addMembers(
        int index, opi_api.network.cloud.v1alpha1.NextHopStatus value) {
      if (membersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMembersIsMutable();
        members_.add(index, value);
        onChanged();
      } else {
        membersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public Builder addMembers(
        opi_api.network.cloud.v1alpha1.NextHopStatus.Builder builderForValue) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        members_.add(builderForValue.build());
        onChanged();
      } else {
        membersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public Builder addMembers(
        int index, opi_api.network.cloud.v1alpha1.NextHopStatus.Builder builderForValue) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        members_.add(index, builderForValue.build());
        onChanged();
      } else {
        membersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public Builder addAllMembers(
        java.lang.Iterable<? extends opi_api.network.cloud.v1alpha1.NextHopStatus> values) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, members_);
        onChanged();
      } else {
        membersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public Builder clearMembers() {
      if (membersBuilder_ == null) {
        members_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        membersBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public Builder removeMembers(int index) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        members_.remove(index);
        onChanged();
      } else {
        membersBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public opi_api.network.cloud.v1alpha1.NextHopStatus.Builder getMembersBuilder(
        int index) {
      return getMembersFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public opi_api.network.cloud.v1alpha1.NextHopStatusOrBuilder getMembersOrBuilder(
        int index) {
      if (membersBuilder_ == null) {
        return members_.get(index);  } else {
        return membersBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public java.util.List<? extends opi_api.network.cloud.v1alpha1.NextHopStatusOrBuilder> 
         getMembersOrBuilderList() {
      if (membersBuilder_ != null) {
        return membersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(members_);
      }
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public opi_api.network.cloud.v1alpha1.NextHopStatus.Builder addMembersBuilder() {
      return getMembersFieldBuilder().addBuilder(
          opi_api.network.cloud.v1alpha1.NextHopStatus.getDefaultInstance());
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public opi_api.network.cloud.v1alpha1.NextHopStatus.Builder addMembersBuilder(
        int index) {
      return getMembersFieldBuilder().addBuilder(
          index, opi_api.network.cloud.v1alpha1.NextHopStatus.getDefaultInstance());
    }
    /**
     * <pre>
     * nexthop group member status
     * </pre>
     *
     * <code>repeated .opi_api.network.cloud.v1alpha1.NextHopStatus members = 1;</code>
     */
    public java.util.List<opi_api.network.cloud.v1alpha1.NextHopStatus.Builder> 
         getMembersBuilderList() {
      return getMembersFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        opi_api.network.cloud.v1alpha1.NextHopStatus, opi_api.network.cloud.v1alpha1.NextHopStatus.Builder, opi_api.network.cloud.v1alpha1.NextHopStatusOrBuilder> 
        getMembersFieldBuilder() {
      if (membersBuilder_ == null) {
        membersBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            opi_api.network.cloud.v1alpha1.NextHopStatus, opi_api.network.cloud.v1alpha1.NextHopStatus.Builder, opi_api.network.cloud.v1alpha1.NextHopStatusOrBuilder>(
                members_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        members_ = null;
      }
      return membersBuilder_;
    }

    private opi_api.network.opinetcommon.v1alpha1.HwHandle hwHandle_;
    private com.google.protobuf.SingleFieldBuilderV3<
        opi_api.network.opinetcommon.v1alpha1.HwHandle, opi_api.network.opinetcommon.v1alpha1.HwHandle.Builder, opi_api.network.opinetcommon.v1alpha1.HwHandleOrBuilder> hwHandleBuilder_;
    /**
     * <pre>
     * nexthop group hw id
     * </pre>
     *
     * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
     * @return Whether the hwHandle field is set.
     */
    public boolean hasHwHandle() {
      return hwHandleBuilder_ != null || hwHandle_ != null;
    }
    /**
     * <pre>
     * nexthop group hw id
     * </pre>
     *
     * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
     * @return The hwHandle.
     */
    public opi_api.network.opinetcommon.v1alpha1.HwHandle getHwHandle() {
      if (hwHandleBuilder_ == null) {
        return hwHandle_ == null ? opi_api.network.opinetcommon.v1alpha1.HwHandle.getDefaultInstance() : hwHandle_;
      } else {
        return hwHandleBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * nexthop group hw id
     * </pre>
     *
     * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
     */
    public Builder setHwHandle(opi_api.network.opinetcommon.v1alpha1.HwHandle value) {
      if (hwHandleBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        hwHandle_ = value;
        onChanged();
      } else {
        hwHandleBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * nexthop group hw id
     * </pre>
     *
     * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
     */
    public Builder setHwHandle(
        opi_api.network.opinetcommon.v1alpha1.HwHandle.Builder builderForValue) {
      if (hwHandleBuilder_ == null) {
        hwHandle_ = builderForValue.build();
        onChanged();
      } else {
        hwHandleBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * nexthop group hw id
     * </pre>
     *
     * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
     */
    public Builder mergeHwHandle(opi_api.network.opinetcommon.v1alpha1.HwHandle value) {
      if (hwHandleBuilder_ == null) {
        if (hwHandle_ != null) {
          hwHandle_ =
            opi_api.network.opinetcommon.v1alpha1.HwHandle.newBuilder(hwHandle_).mergeFrom(value).buildPartial();
        } else {
          hwHandle_ = value;
        }
        onChanged();
      } else {
        hwHandleBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * nexthop group hw id
     * </pre>
     *
     * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
     */
    public Builder clearHwHandle() {
      if (hwHandleBuilder_ == null) {
        hwHandle_ = null;
        onChanged();
      } else {
        hwHandle_ = null;
        hwHandleBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * nexthop group hw id
     * </pre>
     *
     * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
     */
    public opi_api.network.opinetcommon.v1alpha1.HwHandle.Builder getHwHandleBuilder() {
      
      onChanged();
      return getHwHandleFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * nexthop group hw id
     * </pre>
     *
     * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
     */
    public opi_api.network.opinetcommon.v1alpha1.HwHandleOrBuilder getHwHandleOrBuilder() {
      if (hwHandleBuilder_ != null) {
        return hwHandleBuilder_.getMessageOrBuilder();
      } else {
        return hwHandle_ == null ?
            opi_api.network.opinetcommon.v1alpha1.HwHandle.getDefaultInstance() : hwHandle_;
      }
    }
    /**
     * <pre>
     * nexthop group hw id
     * </pre>
     *
     * <code>.opi_api.network.opinetcommon.v1alpha1.HwHandle hw_handle = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        opi_api.network.opinetcommon.v1alpha1.HwHandle, opi_api.network.opinetcommon.v1alpha1.HwHandle.Builder, opi_api.network.opinetcommon.v1alpha1.HwHandleOrBuilder> 
        getHwHandleFieldBuilder() {
      if (hwHandleBuilder_ == null) {
        hwHandleBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            opi_api.network.opinetcommon.v1alpha1.HwHandle, opi_api.network.opinetcommon.v1alpha1.HwHandle.Builder, opi_api.network.opinetcommon.v1alpha1.HwHandleOrBuilder>(
                getHwHandle(),
                getParentForChildren(),
                isClean());
        hwHandle_ = null;
      }
      return hwHandleBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:opi_api.network.cloud.v1alpha1.NextHopGroupStatus)
  }

  // @@protoc_insertion_point(class_scope:opi_api.network.cloud.v1alpha1.NextHopGroupStatus)
  private static final opi_api.network.cloud.v1alpha1.NextHopGroupStatus DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new opi_api.network.cloud.v1alpha1.NextHopGroupStatus();
  }

  public static opi_api.network.cloud.v1alpha1.NextHopGroupStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NextHopGroupStatus>
      PARSER = new com.google.protobuf.AbstractParser<NextHopGroupStatus>() {
    @java.lang.Override
    public NextHopGroupStatus parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new NextHopGroupStatus(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NextHopGroupStatus> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NextHopGroupStatus> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public opi_api.network.cloud.v1alpha1.NextHopGroupStatus getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: frontend_nvme.proto

package opi_api.storage.v1;

/**
 * <pre>
 * Represents a request to update an Nvme Controller.
 * </pre>
 *
 * Protobuf type {@code opi_api.storage.v1.UpdateNvmeControllerRequest}
 */
public final class UpdateNvmeControllerRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:opi_api.storage.v1.UpdateNvmeControllerRequest)
    UpdateNvmeControllerRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UpdateNvmeControllerRequest.newBuilder() to construct.
  private UpdateNvmeControllerRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateNvmeControllerRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UpdateNvmeControllerRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UpdateNvmeControllerRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
            opi_api.storage.v1.NvmeController.Builder subBuilder = null;
            if (nvmeController_ != null) {
              subBuilder = nvmeController_.toBuilder();
            }
            nvmeController_ = input.readMessage(opi_api.storage.v1.NvmeController.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(nvmeController_);
              nvmeController_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            com.google.protobuf.FieldMask.Builder subBuilder = null;
            if (updateMask_ != null) {
              subBuilder = updateMask_.toBuilder();
            }
            updateMask_ = input.readMessage(com.google.protobuf.FieldMask.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(updateMask_);
              updateMask_ = subBuilder.buildPartial();
            }

            break;
          }
          case 24: {

            allowMissing_ = input.readBool();
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
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return opi_api.storage.v1.FrontendNvmeProto.internal_static_opi_api_storage_v1_UpdateNvmeControllerRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return opi_api.storage.v1.FrontendNvmeProto.internal_static_opi_api_storage_v1_UpdateNvmeControllerRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            opi_api.storage.v1.UpdateNvmeControllerRequest.class, opi_api.storage.v1.UpdateNvmeControllerRequest.Builder.class);
  }

  public static final int NVME_CONTROLLER_FIELD_NUMBER = 1;
  private opi_api.storage.v1.NvmeController nvmeController_;
  /**
   * <pre>
   * The object's `name` field is used to identify the object to be updated.
   * </pre>
   *
   * <code>.opi_api.storage.v1.NvmeController nvme_controller = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return Whether the nvmeController field is set.
   */
  @java.lang.Override
  public boolean hasNvmeController() {
    return nvmeController_ != null;
  }
  /**
   * <pre>
   * The object's `name` field is used to identify the object to be updated.
   * </pre>
   *
   * <code>.opi_api.storage.v1.NvmeController nvme_controller = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The nvmeController.
   */
  @java.lang.Override
  public opi_api.storage.v1.NvmeController getNvmeController() {
    return nvmeController_ == null ? opi_api.storage.v1.NvmeController.getDefaultInstance() : nvmeController_;
  }
  /**
   * <pre>
   * The object's `name` field is used to identify the object to be updated.
   * </pre>
   *
   * <code>.opi_api.storage.v1.NvmeController nvme_controller = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  @java.lang.Override
  public opi_api.storage.v1.NvmeControllerOrBuilder getNvmeControllerOrBuilder() {
    return getNvmeController();
  }

  public static final int UPDATE_MASK_FIELD_NUMBER = 2;
  private com.google.protobuf.FieldMask updateMask_;
  /**
   * <pre>
   * The list of fields to update.
   * </pre>
   *
   * <code>.google.protobuf.FieldMask update_mask = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return Whether the updateMask field is set.
   */
  @java.lang.Override
  public boolean hasUpdateMask() {
    return updateMask_ != null;
  }
  /**
   * <pre>
   * The list of fields to update.
   * </pre>
   *
   * <code>.google.protobuf.FieldMask update_mask = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return The updateMask.
   */
  @java.lang.Override
  public com.google.protobuf.FieldMask getUpdateMask() {
    return updateMask_ == null ? com.google.protobuf.FieldMask.getDefaultInstance() : updateMask_;
  }
  /**
   * <pre>
   * The list of fields to update.
   * </pre>
   *
   * <code>.google.protobuf.FieldMask update_mask = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
   */
  @java.lang.Override
  public com.google.protobuf.FieldMaskOrBuilder getUpdateMaskOrBuilder() {
    return getUpdateMask();
  }

  public static final int ALLOW_MISSING_FIELD_NUMBER = 3;
  private boolean allowMissing_;
  /**
   * <pre>
   * If set to true, and the object is not found, a new object will be created.
   * In this situation, `update_mask` is ignored.
   * </pre>
   *
   * <code>bool allow_missing = 3 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return The allowMissing.
   */
  @java.lang.Override
  public boolean getAllowMissing() {
    return allowMissing_;
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
    if (nvmeController_ != null) {
      output.writeMessage(1, getNvmeController());
    }
    if (updateMask_ != null) {
      output.writeMessage(2, getUpdateMask());
    }
    if (allowMissing_ != false) {
      output.writeBool(3, allowMissing_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (nvmeController_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getNvmeController());
    }
    if (updateMask_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getUpdateMask());
    }
    if (allowMissing_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, allowMissing_);
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
    if (!(obj instanceof opi_api.storage.v1.UpdateNvmeControllerRequest)) {
      return super.equals(obj);
    }
    opi_api.storage.v1.UpdateNvmeControllerRequest other = (opi_api.storage.v1.UpdateNvmeControllerRequest) obj;

    if (hasNvmeController() != other.hasNvmeController()) return false;
    if (hasNvmeController()) {
      if (!getNvmeController()
          .equals(other.getNvmeController())) return false;
    }
    if (hasUpdateMask() != other.hasUpdateMask()) return false;
    if (hasUpdateMask()) {
      if (!getUpdateMask()
          .equals(other.getUpdateMask())) return false;
    }
    if (getAllowMissing()
        != other.getAllowMissing()) return false;
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
    if (hasNvmeController()) {
      hash = (37 * hash) + NVME_CONTROLLER_FIELD_NUMBER;
      hash = (53 * hash) + getNvmeController().hashCode();
    }
    if (hasUpdateMask()) {
      hash = (37 * hash) + UPDATE_MASK_FIELD_NUMBER;
      hash = (53 * hash) + getUpdateMask().hashCode();
    }
    hash = (37 * hash) + ALLOW_MISSING_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getAllowMissing());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static opi_api.storage.v1.UpdateNvmeControllerRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static opi_api.storage.v1.UpdateNvmeControllerRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static opi_api.storage.v1.UpdateNvmeControllerRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static opi_api.storage.v1.UpdateNvmeControllerRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static opi_api.storage.v1.UpdateNvmeControllerRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static opi_api.storage.v1.UpdateNvmeControllerRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static opi_api.storage.v1.UpdateNvmeControllerRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static opi_api.storage.v1.UpdateNvmeControllerRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static opi_api.storage.v1.UpdateNvmeControllerRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static opi_api.storage.v1.UpdateNvmeControllerRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static opi_api.storage.v1.UpdateNvmeControllerRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static opi_api.storage.v1.UpdateNvmeControllerRequest parseFrom(
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
  public static Builder newBuilder(opi_api.storage.v1.UpdateNvmeControllerRequest prototype) {
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
   * Represents a request to update an Nvme Controller.
   * </pre>
   *
   * Protobuf type {@code opi_api.storage.v1.UpdateNvmeControllerRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:opi_api.storage.v1.UpdateNvmeControllerRequest)
      opi_api.storage.v1.UpdateNvmeControllerRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return opi_api.storage.v1.FrontendNvmeProto.internal_static_opi_api_storage_v1_UpdateNvmeControllerRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return opi_api.storage.v1.FrontendNvmeProto.internal_static_opi_api_storage_v1_UpdateNvmeControllerRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              opi_api.storage.v1.UpdateNvmeControllerRequest.class, opi_api.storage.v1.UpdateNvmeControllerRequest.Builder.class);
    }

    // Construct using opi_api.storage.v1.UpdateNvmeControllerRequest.newBuilder()
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
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (nvmeControllerBuilder_ == null) {
        nvmeController_ = null;
      } else {
        nvmeController_ = null;
        nvmeControllerBuilder_ = null;
      }
      if (updateMaskBuilder_ == null) {
        updateMask_ = null;
      } else {
        updateMask_ = null;
        updateMaskBuilder_ = null;
      }
      allowMissing_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return opi_api.storage.v1.FrontendNvmeProto.internal_static_opi_api_storage_v1_UpdateNvmeControllerRequest_descriptor;
    }

    @java.lang.Override
    public opi_api.storage.v1.UpdateNvmeControllerRequest getDefaultInstanceForType() {
      return opi_api.storage.v1.UpdateNvmeControllerRequest.getDefaultInstance();
    }

    @java.lang.Override
    public opi_api.storage.v1.UpdateNvmeControllerRequest build() {
      opi_api.storage.v1.UpdateNvmeControllerRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public opi_api.storage.v1.UpdateNvmeControllerRequest buildPartial() {
      opi_api.storage.v1.UpdateNvmeControllerRequest result = new opi_api.storage.v1.UpdateNvmeControllerRequest(this);
      if (nvmeControllerBuilder_ == null) {
        result.nvmeController_ = nvmeController_;
      } else {
        result.nvmeController_ = nvmeControllerBuilder_.build();
      }
      if (updateMaskBuilder_ == null) {
        result.updateMask_ = updateMask_;
      } else {
        result.updateMask_ = updateMaskBuilder_.build();
      }
      result.allowMissing_ = allowMissing_;
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
      if (other instanceof opi_api.storage.v1.UpdateNvmeControllerRequest) {
        return mergeFrom((opi_api.storage.v1.UpdateNvmeControllerRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(opi_api.storage.v1.UpdateNvmeControllerRequest other) {
      if (other == opi_api.storage.v1.UpdateNvmeControllerRequest.getDefaultInstance()) return this;
      if (other.hasNvmeController()) {
        mergeNvmeController(other.getNvmeController());
      }
      if (other.hasUpdateMask()) {
        mergeUpdateMask(other.getUpdateMask());
      }
      if (other.getAllowMissing() != false) {
        setAllowMissing(other.getAllowMissing());
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
      opi_api.storage.v1.UpdateNvmeControllerRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (opi_api.storage.v1.UpdateNvmeControllerRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private opi_api.storage.v1.NvmeController nvmeController_;
    private com.google.protobuf.SingleFieldBuilderV3<
        opi_api.storage.v1.NvmeController, opi_api.storage.v1.NvmeController.Builder, opi_api.storage.v1.NvmeControllerOrBuilder> nvmeControllerBuilder_;
    /**
     * <pre>
     * The object's `name` field is used to identify the object to be updated.
     * </pre>
     *
     * <code>.opi_api.storage.v1.NvmeController nvme_controller = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     * @return Whether the nvmeController field is set.
     */
    public boolean hasNvmeController() {
      return nvmeControllerBuilder_ != null || nvmeController_ != null;
    }
    /**
     * <pre>
     * The object's `name` field is used to identify the object to be updated.
     * </pre>
     *
     * <code>.opi_api.storage.v1.NvmeController nvme_controller = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     * @return The nvmeController.
     */
    public opi_api.storage.v1.NvmeController getNvmeController() {
      if (nvmeControllerBuilder_ == null) {
        return nvmeController_ == null ? opi_api.storage.v1.NvmeController.getDefaultInstance() : nvmeController_;
      } else {
        return nvmeControllerBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * The object's `name` field is used to identify the object to be updated.
     * </pre>
     *
     * <code>.opi_api.storage.v1.NvmeController nvme_controller = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public Builder setNvmeController(opi_api.storage.v1.NvmeController value) {
      if (nvmeControllerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        nvmeController_ = value;
        onChanged();
      } else {
        nvmeControllerBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * The object's `name` field is used to identify the object to be updated.
     * </pre>
     *
     * <code>.opi_api.storage.v1.NvmeController nvme_controller = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public Builder setNvmeController(
        opi_api.storage.v1.NvmeController.Builder builderForValue) {
      if (nvmeControllerBuilder_ == null) {
        nvmeController_ = builderForValue.build();
        onChanged();
      } else {
        nvmeControllerBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * The object's `name` field is used to identify the object to be updated.
     * </pre>
     *
     * <code>.opi_api.storage.v1.NvmeController nvme_controller = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public Builder mergeNvmeController(opi_api.storage.v1.NvmeController value) {
      if (nvmeControllerBuilder_ == null) {
        if (nvmeController_ != null) {
          nvmeController_ =
            opi_api.storage.v1.NvmeController.newBuilder(nvmeController_).mergeFrom(value).buildPartial();
        } else {
          nvmeController_ = value;
        }
        onChanged();
      } else {
        nvmeControllerBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * The object's `name` field is used to identify the object to be updated.
     * </pre>
     *
     * <code>.opi_api.storage.v1.NvmeController nvme_controller = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public Builder clearNvmeController() {
      if (nvmeControllerBuilder_ == null) {
        nvmeController_ = null;
        onChanged();
      } else {
        nvmeController_ = null;
        nvmeControllerBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * The object's `name` field is used to identify the object to be updated.
     * </pre>
     *
     * <code>.opi_api.storage.v1.NvmeController nvme_controller = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public opi_api.storage.v1.NvmeController.Builder getNvmeControllerBuilder() {
      
      onChanged();
      return getNvmeControllerFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * The object's `name` field is used to identify the object to be updated.
     * </pre>
     *
     * <code>.opi_api.storage.v1.NvmeController nvme_controller = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public opi_api.storage.v1.NvmeControllerOrBuilder getNvmeControllerOrBuilder() {
      if (nvmeControllerBuilder_ != null) {
        return nvmeControllerBuilder_.getMessageOrBuilder();
      } else {
        return nvmeController_ == null ?
            opi_api.storage.v1.NvmeController.getDefaultInstance() : nvmeController_;
      }
    }
    /**
     * <pre>
     * The object's `name` field is used to identify the object to be updated.
     * </pre>
     *
     * <code>.opi_api.storage.v1.NvmeController nvme_controller = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        opi_api.storage.v1.NvmeController, opi_api.storage.v1.NvmeController.Builder, opi_api.storage.v1.NvmeControllerOrBuilder> 
        getNvmeControllerFieldBuilder() {
      if (nvmeControllerBuilder_ == null) {
        nvmeControllerBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            opi_api.storage.v1.NvmeController, opi_api.storage.v1.NvmeController.Builder, opi_api.storage.v1.NvmeControllerOrBuilder>(
                getNvmeController(),
                getParentForChildren(),
                isClean());
        nvmeController_ = null;
      }
      return nvmeControllerBuilder_;
    }

    private com.google.protobuf.FieldMask updateMask_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.FieldMask, com.google.protobuf.FieldMask.Builder, com.google.protobuf.FieldMaskOrBuilder> updateMaskBuilder_;
    /**
     * <pre>
     * The list of fields to update.
     * </pre>
     *
     * <code>.google.protobuf.FieldMask update_mask = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
     * @return Whether the updateMask field is set.
     */
    public boolean hasUpdateMask() {
      return updateMaskBuilder_ != null || updateMask_ != null;
    }
    /**
     * <pre>
     * The list of fields to update.
     * </pre>
     *
     * <code>.google.protobuf.FieldMask update_mask = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
     * @return The updateMask.
     */
    public com.google.protobuf.FieldMask getUpdateMask() {
      if (updateMaskBuilder_ == null) {
        return updateMask_ == null ? com.google.protobuf.FieldMask.getDefaultInstance() : updateMask_;
      } else {
        return updateMaskBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * The list of fields to update.
     * </pre>
     *
     * <code>.google.protobuf.FieldMask update_mask = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
     */
    public Builder setUpdateMask(com.google.protobuf.FieldMask value) {
      if (updateMaskBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        updateMask_ = value;
        onChanged();
      } else {
        updateMaskBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * The list of fields to update.
     * </pre>
     *
     * <code>.google.protobuf.FieldMask update_mask = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
     */
    public Builder setUpdateMask(
        com.google.protobuf.FieldMask.Builder builderForValue) {
      if (updateMaskBuilder_ == null) {
        updateMask_ = builderForValue.build();
        onChanged();
      } else {
        updateMaskBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * The list of fields to update.
     * </pre>
     *
     * <code>.google.protobuf.FieldMask update_mask = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
     */
    public Builder mergeUpdateMask(com.google.protobuf.FieldMask value) {
      if (updateMaskBuilder_ == null) {
        if (updateMask_ != null) {
          updateMask_ =
            com.google.protobuf.FieldMask.newBuilder(updateMask_).mergeFrom(value).buildPartial();
        } else {
          updateMask_ = value;
        }
        onChanged();
      } else {
        updateMaskBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * The list of fields to update.
     * </pre>
     *
     * <code>.google.protobuf.FieldMask update_mask = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
     */
    public Builder clearUpdateMask() {
      if (updateMaskBuilder_ == null) {
        updateMask_ = null;
        onChanged();
      } else {
        updateMask_ = null;
        updateMaskBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * The list of fields to update.
     * </pre>
     *
     * <code>.google.protobuf.FieldMask update_mask = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
     */
    public com.google.protobuf.FieldMask.Builder getUpdateMaskBuilder() {
      
      onChanged();
      return getUpdateMaskFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * The list of fields to update.
     * </pre>
     *
     * <code>.google.protobuf.FieldMask update_mask = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
     */
    public com.google.protobuf.FieldMaskOrBuilder getUpdateMaskOrBuilder() {
      if (updateMaskBuilder_ != null) {
        return updateMaskBuilder_.getMessageOrBuilder();
      } else {
        return updateMask_ == null ?
            com.google.protobuf.FieldMask.getDefaultInstance() : updateMask_;
      }
    }
    /**
     * <pre>
     * The list of fields to update.
     * </pre>
     *
     * <code>.google.protobuf.FieldMask update_mask = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.FieldMask, com.google.protobuf.FieldMask.Builder, com.google.protobuf.FieldMaskOrBuilder> 
        getUpdateMaskFieldBuilder() {
      if (updateMaskBuilder_ == null) {
        updateMaskBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.FieldMask, com.google.protobuf.FieldMask.Builder, com.google.protobuf.FieldMaskOrBuilder>(
                getUpdateMask(),
                getParentForChildren(),
                isClean());
        updateMask_ = null;
      }
      return updateMaskBuilder_;
    }

    private boolean allowMissing_ ;
    /**
     * <pre>
     * If set to true, and the object is not found, a new object will be created.
     * In this situation, `update_mask` is ignored.
     * </pre>
     *
     * <code>bool allow_missing = 3 [(.google.api.field_behavior) = OPTIONAL];</code>
     * @return The allowMissing.
     */
    @java.lang.Override
    public boolean getAllowMissing() {
      return allowMissing_;
    }
    /**
     * <pre>
     * If set to true, and the object is not found, a new object will be created.
     * In this situation, `update_mask` is ignored.
     * </pre>
     *
     * <code>bool allow_missing = 3 [(.google.api.field_behavior) = OPTIONAL];</code>
     * @param value The allowMissing to set.
     * @return This builder for chaining.
     */
    public Builder setAllowMissing(boolean value) {
      
      allowMissing_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * If set to true, and the object is not found, a new object will be created.
     * In this situation, `update_mask` is ignored.
     * </pre>
     *
     * <code>bool allow_missing = 3 [(.google.api.field_behavior) = OPTIONAL];</code>
     * @return This builder for chaining.
     */
    public Builder clearAllowMissing() {
      
      allowMissing_ = false;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:opi_api.storage.v1.UpdateNvmeControllerRequest)
  }

  // @@protoc_insertion_point(class_scope:opi_api.storage.v1.UpdateNvmeControllerRequest)
  private static final opi_api.storage.v1.UpdateNvmeControllerRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new opi_api.storage.v1.UpdateNvmeControllerRequest();
  }

  public static opi_api.storage.v1.UpdateNvmeControllerRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateNvmeControllerRequest>
      PARSER = new com.google.protobuf.AbstractParser<UpdateNvmeControllerRequest>() {
    @java.lang.Override
    public UpdateNvmeControllerRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UpdateNvmeControllerRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateNvmeControllerRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateNvmeControllerRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public opi_api.storage.v1.UpdateNvmeControllerRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: WestMessage.proto

package co.niagarasystems.west.pb;

public final class MessageProtos {
  private MessageProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface MessageOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required string event = 1;
    /**
     * <code>required string event = 1;</code>
     */
    boolean hasEvent();
    /**
     * <code>required string event = 1;</code>
     */
    java.lang.String getEvent();
    /**
     * <code>required string event = 1;</code>
     */
    com.google.protobuf.ByteString
        getEventBytes();

    // optional string channel = 2;
    /**
     * <code>optional string channel = 2;</code>
     */
    boolean hasChannel();
    /**
     * <code>optional string channel = 2;</code>
     */
    java.lang.String getChannel();
    /**
     * <code>optional string channel = 2;</code>
     */
    com.google.protobuf.ByteString
        getChannelBytes();

    // optional string from = 3;
    /**
     * <code>optional string from = 3;</code>
     */
    boolean hasFrom();
    /**
     * <code>optional string from = 3;</code>
     */
    java.lang.String getFrom();
    /**
     * <code>optional string from = 3;</code>
     */
    com.google.protobuf.ByteString
        getFromBytes();

    // optional string id = 4;
    /**
     * <code>optional string id = 4;</code>
     */
    boolean hasId();
    /**
     * <code>optional string id = 4;</code>
     */
    java.lang.String getId();
    /**
     * <code>optional string id = 4;</code>
     */
    com.google.protobuf.ByteString
        getIdBytes();

    // optional bytes data = 5;
    /**
     * <code>optional bytes data = 5;</code>
     */
    boolean hasData();
    /**
     * <code>optional bytes data = 5;</code>
     */
    com.google.protobuf.ByteString getData();
  }
  /**
   * Protobuf type {@code Message}
   *
   * <pre>
   * WEST message specification
   * </pre>
   */
  public static final class Message extends
      com.google.protobuf.GeneratedMessage
      implements MessageOrBuilder {
    // Use Message.newBuilder() to construct.
    private Message(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Message(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Message defaultInstance;
    public static Message getDefaultInstance() {
      return defaultInstance;
    }

    public Message getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Message(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      //int mutable_bitField0_ = 0;
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
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              event_ = input.readBytes();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              channel_ = input.readBytes();
              break;
            }
            case 26: {
              bitField0_ |= 0x00000004;
              from_ = input.readBytes();
              break;
            }
            case 34: {
              bitField0_ |= 0x00000008;
              id_ = input.readBytes();
              break;
            }
            case 42: {
              bitField0_ |= 0x00000010;
              data_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return co.niagarasystems.west.pb.MessageProtos.internal_static_Message_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return co.niagarasystems.west.pb.MessageProtos.internal_static_Message_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              co.niagarasystems.west.pb.MessageProtos.Message.class, co.niagarasystems.west.pb.MessageProtos.Message.Builder.class);
    }

    public static com.google.protobuf.Parser<Message> PARSER =
        new com.google.protobuf.AbstractParser<Message>() {
      public Message parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Message(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Message> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required string event = 1;
    public static final int EVENT_FIELD_NUMBER = 1;
    private java.lang.Object event_;
    /**
     * <code>required string event = 1;</code>
     */
    public boolean hasEvent() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string event = 1;</code>
     */
    public java.lang.String getEvent() {
      java.lang.Object ref = event_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          event_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string event = 1;</code>
     */
    public com.google.protobuf.ByteString
        getEventBytes() {
      java.lang.Object ref = event_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        event_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // optional string channel = 2;
    public static final int CHANNEL_FIELD_NUMBER = 2;
    private java.lang.Object channel_;
    /**
     * <code>optional string channel = 2;</code>
     */
    public boolean hasChannel() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string channel = 2;</code>
     */
    public java.lang.String getChannel() {
      java.lang.Object ref = channel_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          channel_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string channel = 2;</code>
     */
    public com.google.protobuf.ByteString
        getChannelBytes() {
      java.lang.Object ref = channel_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        channel_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // optional string from = 3;
    public static final int FROM_FIELD_NUMBER = 3;
    private java.lang.Object from_;
    /**
     * <code>optional string from = 3;</code>
     */
    public boolean hasFrom() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional string from = 3;</code>
     */
    public java.lang.String getFrom() {
      java.lang.Object ref = from_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          from_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string from = 3;</code>
     */
    public com.google.protobuf.ByteString
        getFromBytes() {
      java.lang.Object ref = from_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        from_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // optional string id = 4;
    public static final int ID_FIELD_NUMBER = 4;
    private java.lang.Object id_;
    /**
     * <code>optional string id = 4;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional string id = 4;</code>
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          id_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string id = 4;</code>
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // optional bytes data = 5;
    public static final int DATA_FIELD_NUMBER = 5;
    private com.google.protobuf.ByteString data_;
    /**
     * <code>optional bytes data = 5;</code>
     */
    public boolean hasData() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional bytes data = 5;</code>
     */
    public com.google.protobuf.ByteString getData() {
      return data_;
    }

    private void initFields() {
      event_ = "";
      channel_ = "";
      from_ = "";
      id_ = "";
      data_ = com.google.protobuf.ByteString.EMPTY;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasEvent()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getEventBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getChannelBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBytes(3, getFromBytes());
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeBytes(4, getIdBytes());
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeBytes(5, data_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getEventBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getChannelBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, getFromBytes());
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, getIdBytes());
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(5, data_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static co.niagarasystems.west.pb.MessageProtos.Message parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static co.niagarasystems.west.pb.MessageProtos.Message parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static co.niagarasystems.west.pb.MessageProtos.Message parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static co.niagarasystems.west.pb.MessageProtos.Message parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static co.niagarasystems.west.pb.MessageProtos.Message parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static co.niagarasystems.west.pb.MessageProtos.Message parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static co.niagarasystems.west.pb.MessageProtos.Message parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static co.niagarasystems.west.pb.MessageProtos.Message parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static co.niagarasystems.west.pb.MessageProtos.Message parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static co.niagarasystems.west.pb.MessageProtos.Message parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(co.niagarasystems.west.pb.MessageProtos.Message prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Message}
     *
     * <pre>
     * WEST message specification
     * </pre>
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements co.niagarasystems.west.pb.MessageProtos.MessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return co.niagarasystems.west.pb.MessageProtos.internal_static_Message_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return co.niagarasystems.west.pb.MessageProtos.internal_static_Message_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                co.niagarasystems.west.pb.MessageProtos.Message.class, co.niagarasystems.west.pb.MessageProtos.Message.Builder.class);
      }

      // Construct using co.niagarasystems.west.protos.MessageProtos.Message.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        event_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        channel_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        from_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        id_ = "";
        bitField0_ = (bitField0_ & ~0x00000008);
        data_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return co.niagarasystems.west.pb.MessageProtos.internal_static_Message_descriptor;
      }

      public co.niagarasystems.west.pb.MessageProtos.Message getDefaultInstanceForType() {
        return co.niagarasystems.west.pb.MessageProtos.Message.getDefaultInstance();
      }

      public co.niagarasystems.west.pb.MessageProtos.Message build() {
        co.niagarasystems.west.pb.MessageProtos.Message result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public co.niagarasystems.west.pb.MessageProtos.Message buildPartial() {
        co.niagarasystems.west.pb.MessageProtos.Message result = new co.niagarasystems.west.pb.MessageProtos.Message(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.event_ = event_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.channel_ = channel_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.from_ = from_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.id_ = id_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.data_ = data_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof co.niagarasystems.west.pb.MessageProtos.Message) {
          return mergeFrom((co.niagarasystems.west.pb.MessageProtos.Message)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(co.niagarasystems.west.pb.MessageProtos.Message other) {
        if (other == co.niagarasystems.west.pb.MessageProtos.Message.getDefaultInstance()) return this;
        if (other.hasEvent()) {
          bitField0_ |= 0x00000001;
          event_ = other.event_;
          onChanged();
        }
        if (other.hasChannel()) {
          bitField0_ |= 0x00000002;
          channel_ = other.channel_;
          onChanged();
        }
        if (other.hasFrom()) {
          bitField0_ |= 0x00000004;
          from_ = other.from_;
          onChanged();
        }
        if (other.hasId()) {
          bitField0_ |= 0x00000008;
          id_ = other.id_;
          onChanged();
        }
        if (other.hasData()) {
          setData(other.getData());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasEvent()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        co.niagarasystems.west.pb.MessageProtos.Message parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (co.niagarasystems.west.pb.MessageProtos.Message) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required string event = 1;
      private java.lang.Object event_ = "";
      /**
       * <code>required string event = 1;</code>
       */
      public boolean hasEvent() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string event = 1;</code>
       */
      public java.lang.String getEvent() {
        java.lang.Object ref = event_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          event_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string event = 1;</code>
       */
      public com.google.protobuf.ByteString
          getEventBytes() {
        java.lang.Object ref = event_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          event_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string event = 1;</code>
       */
      public Builder setEvent(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        event_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string event = 1;</code>
       */
      public Builder clearEvent() {
        bitField0_ = (bitField0_ & ~0x00000001);
        event_ = getDefaultInstance().getEvent();
        onChanged();
        return this;
      }
      /**
       * <code>required string event = 1;</code>
       */
      public Builder setEventBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        event_ = value;
        onChanged();
        return this;
      }

      // optional string channel = 2;
      private java.lang.Object channel_ = "";
      /**
       * <code>optional string channel = 2;</code>
       */
      public boolean hasChannel() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional string channel = 2;</code>
       */
      public java.lang.String getChannel() {
        java.lang.Object ref = channel_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          channel_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string channel = 2;</code>
       */
      public com.google.protobuf.ByteString
          getChannelBytes() {
        java.lang.Object ref = channel_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          channel_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string channel = 2;</code>
       */
      public Builder setChannel(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        channel_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string channel = 2;</code>
       */
      public Builder clearChannel() {
        bitField0_ = (bitField0_ & ~0x00000002);
        channel_ = getDefaultInstance().getChannel();
        onChanged();
        return this;
      }
      /**
       * <code>optional string channel = 2;</code>
       */
      public Builder setChannelBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        channel_ = value;
        onChanged();
        return this;
      }

      // optional string from = 3;
      private java.lang.Object from_ = "";
      /**
       * <code>optional string from = 3;</code>
       */
      public boolean hasFrom() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional string from = 3;</code>
       */
      public java.lang.String getFrom() {
        java.lang.Object ref = from_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          from_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string from = 3;</code>
       */
      public com.google.protobuf.ByteString
          getFromBytes() {
        java.lang.Object ref = from_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          from_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string from = 3;</code>
       */
      public Builder setFrom(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        from_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string from = 3;</code>
       */
      public Builder clearFrom() {
        bitField0_ = (bitField0_ & ~0x00000004);
        from_ = getDefaultInstance().getFrom();
        onChanged();
        return this;
      }
      /**
       * <code>optional string from = 3;</code>
       */
      public Builder setFromBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        from_ = value;
        onChanged();
        return this;
      }

      // optional string id = 4;
      private java.lang.Object id_ = "";
      /**
       * <code>optional string id = 4;</code>
       */
      public boolean hasId() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>optional string id = 4;</code>
       */
      public java.lang.String getId() {
        java.lang.Object ref = id_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          id_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string id = 4;</code>
       */
      public com.google.protobuf.ByteString
          getIdBytes() {
        java.lang.Object ref = id_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          id_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string id = 4;</code>
       */
      public Builder setId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string id = 4;</code>
       */
      public Builder clearId() {
        bitField0_ = (bitField0_ & ~0x00000008);
        id_ = getDefaultInstance().getId();
        onChanged();
        return this;
      }
      /**
       * <code>optional string id = 4;</code>
       */
      public Builder setIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        id_ = value;
        onChanged();
        return this;
      }

      // optional bytes data = 5;
      private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>optional bytes data = 5;</code>
       */
      public boolean hasData() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>optional bytes data = 5;</code>
       */
      public com.google.protobuf.ByteString getData() {
        return data_;
      }
      /**
       * <code>optional bytes data = 5;</code>
       */
      public Builder setData(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        data_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bytes data = 5;</code>
       */
      public Builder clearData() {
        bitField0_ = (bitField0_ & ~0x00000010);
        data_ = getDefaultInstance().getData();
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Message)
    }

    static {
      defaultInstance = new Message(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:Message)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Message_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021WestMessage.proto\"Q\n\007Message\022\r\n\005event\030" +
      "\001 \002(\t\022\017\n\007channel\030\002 \001(\t\022\014\n\004from\030\003 \001(\t\022\n\n\002" +
      "id\030\004 \001(\t\022\014\n\004data\030\005 \001(\014B.\n\035co.niagarasyst" +
      "ems.west.protosB\rMessageProtos"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_Message_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_Message_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_Message_descriptor,
              new java.lang.String[] { "Event", "Channel", "From", "Id", "Data", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
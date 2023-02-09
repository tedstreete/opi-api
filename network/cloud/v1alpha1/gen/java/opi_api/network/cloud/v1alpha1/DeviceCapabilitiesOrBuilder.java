// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: device.proto

package opi_api.network.cloud.v1alpha1;

public interface DeviceCapabilitiesOrBuilder extends
    // @@protoc_insertion_point(interface_extends:opi_api.network.cloud.v1alpha1.DeviceCapabilities)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * traffic routing capabilities
   * </pre>
   *
   * <code>.opi_api.network.cloud.v1alpha1.DeviceCapabilitiesDynamicRouting routing_capabilties = 1;</code>
   * @return Whether the routingCapabilties field is set.
   */
  boolean hasRoutingCapabilties();
  /**
   * <pre>
   * traffic routing capabilities
   * </pre>
   *
   * <code>.opi_api.network.cloud.v1alpha1.DeviceCapabilitiesDynamicRouting routing_capabilties = 1;</code>
   * @return The routingCapabilties.
   */
  opi_api.network.cloud.v1alpha1.DeviceCapabilitiesDynamicRouting getRoutingCapabilties();
  /**
   * <pre>
   * traffic routing capabilities
   * </pre>
   *
   * <code>.opi_api.network.cloud.v1alpha1.DeviceCapabilitiesDynamicRouting routing_capabilties = 1;</code>
   */
  opi_api.network.cloud.v1alpha1.DeviceCapabilitiesDynamicRoutingOrBuilder getRoutingCapabiltiesOrBuilder();

  /**
   * <pre>
   * network security policy capabilities
   * </pre>
   *
   * <code>.opi_api.network.cloud.v1alpha1.DeviceCapabilitiesNetworkPolicy network_policy_capabilities = 2;</code>
   * @return Whether the networkPolicyCapabilities field is set.
   */
  boolean hasNetworkPolicyCapabilities();
  /**
   * <pre>
   * network security policy capabilities
   * </pre>
   *
   * <code>.opi_api.network.cloud.v1alpha1.DeviceCapabilitiesNetworkPolicy network_policy_capabilities = 2;</code>
   * @return The networkPolicyCapabilities.
   */
  opi_api.network.cloud.v1alpha1.DeviceCapabilitiesNetworkPolicy getNetworkPolicyCapabilities();
  /**
   * <pre>
   * network security policy capabilities
   * </pre>
   *
   * <code>.opi_api.network.cloud.v1alpha1.DeviceCapabilitiesNetworkPolicy network_policy_capabilities = 2;</code>
   */
  opi_api.network.cloud.v1alpha1.DeviceCapabilitiesNetworkPolicyOrBuilder getNetworkPolicyCapabilitiesOrBuilder();
}